package com.ncs.fontfulllibrary

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider

open class FontFull{
    class FontStyleBottomSheetDialog {
        interface OnFontStyleSelectedListener {
            fun onFontStyleSelected(typeface: Typeface)
        }

        companion object {
            @JvmStatic
            fun showFontStyleBottomSheet(context: Context, listener: OnFontStyleSelectedListener) {
                val fontStyleList = listOf(
                    R.font.outfitextrabold,
                    R.font.outfitlight,
                    R.font.kablammo,
                    R.font.tiltprism,
                    R.font.dancing,
                    R.font.pacifico,
                    R.font.caveat,
                    R.font.shadowsintolight,
                    R.font.ecular,
                    R.font.indie,
                    R.font.pressstart,
                    R.font.monoton,
                    R.font.couruer,
                    R.font.vt,
                    R.font.nova,
                    R.font.greatvibes,
                    R.font.pinyon,
                    R.font.fredricka
                )
                val bottomSheetDialog = BottomSheetDialog(context)
                val recyclerView = RecyclerView(context)
                recyclerView.layoutManager = LinearLayoutManager(context)
                val adapter = FontStyleAdapter(fontStyleList) { fontStyle ->
                    val typeface = ResourcesCompat.getFont(context, fontStyle)
                    if (typeface != null) {
                        listener.onFontStyleSelected(typeface)
                    }
                    bottomSheetDialog.dismiss()
                }
                recyclerView.adapter = adapter
                bottomSheetDialog.setContentView(recyclerView)
                bottomSheetDialog.show()
            }
        }
    }
    class FontSizeBottomSheetDialog(private val context: Context) {
        private val bottomSheetDialog: BottomSheetDialog
        private val bottomSheetView: View
        private val bottomSheetBehavior: BottomSheetBehavior<View>
        private val slider: Slider

        private var sizeChangeListener: ((Float) -> Unit)? = null

        init {
            bottomSheetDialog = BottomSheetDialog(context)
            bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog, null)
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView.parent as View)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

            slider = bottomSheetView.findViewById(R.id.slider)
            slider.valueFrom = 10f
            slider.valueTo = 100f
            slider.stepSize = 1f
            slider.value = 55f
            slider.addOnChangeListener { slider, value, fromUser ->
                val selectedValue = value.toInt()
                sizeChangeListener?.invoke(selectedValue.toFloat())
            }
        }
        fun setSizeChangeListener(listener: (Float) -> Unit) {
            sizeChangeListener = listener
        }
        fun show() {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetDialog.show()
        }
    }
    class ColorPickerBottomSheet : BottomSheetDialogFragment() {

        private lateinit var colorWheelImageView: ImageView
        private lateinit var colorView: View
        private lateinit var button: Button
        private lateinit var cancelbutton: Button

        private var onColorSelectedListener: ((Int) -> Unit)? = null
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.bottom_sheet_color_picker, container, false)
            colorWheelImageView = view.findViewById(R.id.colorWheelImageView)
            colorView = view.findViewById(R.id.colour)
            button=view.findViewById(R.id.button)
            cancelbutton=view.findViewById(R.id.cancelbutton)
            colorWheelImageView.setOnTouchListener { _, event ->
                val bitmap = colorWheelImageView.drawable.toBitmap()
                if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                    val x = event.x.toInt().coerceIn(0, bitmap.width - 1)
                    val y = event.y.toInt().coerceIn(0, bitmap.height - 1)
                    val color = bitmap.getPixel(x, y)
                    colorView.setBackgroundColor(color)
                    onColorSelectedListener?.invoke(color)
                    colorView.visibility=View.VISIBLE
                }
                true
            }
            button.setOnClickListener {
                dismiss()
            }
            cancelbutton.setOnClickListener {
                dismiss()
            }
            return view
        }
        fun setOnColorSelectedListener(listener: (Int) -> Unit) {
            onColorSelectedListener = listener
        }

    }
}

