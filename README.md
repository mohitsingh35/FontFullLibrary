  # FontFullLibrary ツ 

FontFull is a demonstration library created as a self-teaching project, packed with excellent font formatting features in just 4 lines of code

<a href="https://github.com/mohitsingh35/FontFullLibrary/blob/master/Sample.apk">Download Sample APK</a> ---> Click on "download raw"


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
