# eBay Kleinanzeigen Android Coding Challenge

Congratulations! You made it to the eBay Kleinanzeigen remote coding challenge for Android. Here, we want to get a taste of your hands-on coding skills as well as your understanding of design and product descriptions.

## Background
Since our View Item Page (= VIP) is a bit outdated, we want to re-brush our VIP on all platforms – also on Android.


## To Do
Please create a new VIP for Android matching the design (see the design in project root folder for colors, font sizes, icons, 
etc - VIP_Design.pdf). All necessary image assets and colors are already defined in the res/ folder.

You can use any library or tool. It’s expected to apply an architectural pattern and to provide a well structured code.

### General information:
* See design of the sections in the attached design (sections are separated by a thick grey line)
* Size of sections adapts dynamically according the number of attributes (e.g. “Zimmer”) / contents (e.g. having additional documents such as PDF)
* If there is no content for a section (ex. no uploaded PDF, no attributes for “Ausstattung”, etc.), the section should collapse)

### Section: Images
* Show all the images in a horizontally swipeable gallery
* Show the first picture of the ad by default
* Show the share icon on the top right on the picture
* On the bottom left there is the number of the displayed picture and the number of pictures in total; divided by “/”
the user should be able to swipe through the gallery (Font size: 14, Text color: @color/black, Background color: @color/black_transparent)
* Clicking on an image opens it in a new screen with bigger resolution

### Section: Basic Info (directly below the picture) 
* Ad title (Json key: title)
* Price and currency (Json key: price)
* Address in the format "Street, ZIP Code, City" (it’s a link to google maps with the given latitude and longitude) (Json key: address)
* Calendar icon + creation date (Json key: posted-date-time)
* Views icon + number of visits (Json key: visits)
* Show ‘ID:’ and add Ad-ID (Json key: id)

### Section: Details
* Show headline: ‘Details’
* List all attributes coming from backend and the respective value and unit (Json key: attributes)

### Section: Features (Ausstattung) 
* Show headline ‘Ausstattung’
* List respective features in two columns (Json key: features)
* Keep order of features; logic: left, right, left, right, etc
* Put a green check before every feature in this section (asset provided in drawable folder)

### Section: Documents (PDFs)
* Show headline ‘Weitere Informationen’
* Show PDF icon and Name of PDF and chevron (Json key: documents)
* When the user clicks on a document, the respective PDF opens in a browser

### Section: Description
* Show headline ‘Beschreibung’
* Show the description coming from the backend (Json key: description)

## Technical Details
* You can use any library or tool
* It’s expected to apply an architectural pattern and to provide a well structured code
* Expected language for the challenge is Kotlin
* The app should request and parse content from our JSON service
* The app should load images from the URL that is part of the response

### API Details
* API endpoint URL: https://gateway.ebay-kleinanzeigen.de/coding-challenge/api/v1/ads/{ad_id}
* Ad ID to request: 1118635128
* Authorization: Basic Authentication
* Credentials:
  * Username: candidate
  * Password: LnpwL7HoZjTL

### Additional Info
* To generate the real image url replace the {imageId} placeholder with the string 1 or 57 accordingly for preview or full size.

Example:
`https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/LukAAOSwZEFhSgCC_{imageId}.jpeg`
should be converted to
`https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/LukAAOSwZEFhSgCC_1.jpeg` for preview
and
`https://gateway.ebay-kleinanzeigen.de/coding-challenge/img/LukAAOSwZEFhSgCC_57.jpeg` for full size image.

### Sample Json Output

**Run this curl command to get the sample data:**

```
curl --basic -u candidate:LnpwL7HoZjTL --user-agent "some-user-agent" https://gateway.ebay-kleinanzeigen.de/coding-challenge/api/v1/ads/1118635128
```

## Final Remarks

* You have 1 week to complete the challenge.
* It is expected to provide a solution with a good architectural structure and preferably with some tests.
* Please fill out the rest of this README file that explains your approach.
* Once you’re done with the challenge, please zip the project folder, upload it to Google Drive and send us the publicly available link to the zip file on Google Drive.

**Have fun!**


## Your comments / remarks

How did you approach the task?
- I started with modularizing my components and detecting what was needed from the requirement.
- I specified the layers needed and started to implement them from the most abstracted one to the outer layer.
- I put the common resource and layouts and style in a shared module to use through the app
- it is my first time working with a compose in a multi-module project.
- I faced some challenges in the compose UI, and hilt integration to the multi-modules app.
- the technologies I have used:
  - kotlin.
  - Hilt (dependancy injection).
  - andoridx.
  - matrial design (check the payment part).
  - compose
  - retrofit.
  - okhttp.
  - coroutines.
  - unit test (junit)
  - ui test (espresso) (integration only)

What architecture layers did you create and why?
I used a clean architecture with a multi-module project integrated with the repository pattern and MVVM architecture pattern.
- data layer:
  - contains the setup of the:
    - network layer.
    - modules / data responses
    - repositories
    - data mapping.
- domain layer:
  - contains the business use-cases in our case we have only one business case which is retrieving the ADS.
- presentation layers:
  - in multi-modules projects usually, create a new module for each feature or implement data
- common-resources layer
  - contains the shared resources and styles that can be used through the features.

Note: as we have only one feature module so I made the layers serve this module. but if we have multi features we have to include the clases and data related to to this feature inside its package

What would you do if you had more time?
- migrate to kotlin DSL.
- add more unit tests for the logic I just did a POC of how to test.
- add compose UI test I just put the setup of the espresso but usually we test compose with another way.

Which trade-offs did you take?

