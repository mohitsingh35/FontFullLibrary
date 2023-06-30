  # FontFullLibrary ツ 

FontFull is a demonstration library created as a self-teaching project, packed with excellent font formatting features in just 4 lines of code

Download Sample APK 
<button data-component="IconButton" aria-label="Download raw content" data-testid="download-raw-button" data-hotkey="Control+Shift+s" data-size="small" data-no-visuals="true" class="types__StyledButton-sc-ws60qy-0 ddNLNa"><svg aria-hidden="true" focusable="false" role="img" class="octicon octicon-download" viewBox="0 0 16 16" width="16" height="16" fill="currentColor" style="display: inline-block; user-select: none; vertical-align: text-bottom; overflow: visible;"><path d="M2.75 14A1.75 1.75 0 0 1 1 12.25v-2.5a.75.75 0 0 1 1.5 0v2.5c0 .138.112.25.25.25h10.5a.25.25 0 0 0 .25-.25v-2.5a.75.75 0 0 1 1.5 0v2.5A1.75 1.75 0 0 1 13.25 14Z"></path><path d="M7.25 7.689V2a.75.75 0 0 1 1.5 0v5.689l1.97-1.969a.749.749 0 1 1 1.06 1.06l-3.25 3.25a.749.749 0 0 1-1.06 0L4.22 6.78a.749.749 0 1 1 1.06-1.06l1.97 1.969Z"></path></svg></button>

# Features

![Main Screen](https://github.com/mohitsingh35/FontFullLibrary/assets/130476288/a444dd62-91ca-4e7f-920d-ce269a91dc48)


1. **FontStyle BottomSheet** :

   You can integrate some of the widely used typefaces in your app without having to download each separately yourself has the liberty to add your own typefaces as well.

![Font Style](https://github.com/mohitsingh35/FontFullLibrary/assets/130476288/d55769ad-cf65-4118-bec9-bdfc43ad1724)


2. **Font Size Slider** :

   The font size selector slider is available in the bottom sheet and can be directly used to set the text size.

![Font Size](https://github.com/mohitsingh35/FontFullLibrary/assets/130476288/57a03bf3-e3ee-40a2-bd1a-34f101ab62a7)


3. **Font Color Picker Menu**:

   Integrated into the bottom sheet, the color picker menu offers a clean UI and functions well to set the color of the text.
   
![Font Color](https://github.com/mohitsingh35/FontFullLibrary/assets/130476288/0ccd77c4-e6f0-4820-96f1-96fa29016ad8)


# Installation

   Installation of FontFull is really very simple, follow the below steps to get started!


### Using Gradle

   Step 1 : Use this in settings.gradle

    pluginManagement {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
      
        }
    }

   Step 2 : Use this in build.gradle (module:app)

   
    dependencies { 
    
       implementation 'com.github.mohitsingh35:FontFullLibrary:1.0'
       
	}

 

 # Usage
```kotlin

//FontStyle Usage

//this is a sample button change it in your code
FontStylebutton.setOnClickListener {
            val fontStyleSelectedListener = object : FontFull.FontStyleBottomSheetDialog.OnFontStyleSelectedListener {
                override fun onFontStyleSelected(typeface: Typeface) {
                    textView.typeface=typeface  // don't forget to change your textview here
                }
            }
            FontFull.FontStyleBottomSheetDialog.showFontStyleBottomSheet(this, fontStyleSelectedListener)
        }
```



```kotlin

//FontSize Usage

val fontSizeBottomSheetDialog = FontFull.FontSizeBottomSheetDialog(this)
        fontSizeBottomSheetDialog.setSizeChangeListener { selectedValue ->
            textView.textSize = selectedValue  // don't forget to change your textview here
        }
        FontSizebutton.setOnClickListener {    // open the bottom sheet
            fontSizeBottomSheetDialog.show()
        }

```


```kotlin

//FontColor Usage

//this is a sample button change it in your code
FontColorbutton.setOnClickListener {
            val colorPickerBottomSheet = FontFull.ColorPickerBottomSheet()
            colorPickerBottomSheet.setOnColorSelectedListener { color ->
                textView.setTextColor(color) // don't forget to change your textview here
            }
            colorPickerBottomSheet.show(supportFragmentManager, "colorPicker")
        }

```

# Customisations

New FontStyles can be added by the desired .ttf file of font in res/font and then adding this in FontFull class inside fontstylelist as R.font.your_font

### Other customizations will be added in future releases

Peace out 🤞
