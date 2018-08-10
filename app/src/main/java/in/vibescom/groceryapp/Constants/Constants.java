package in.vibescom.groceryapp.Constants;

public interface Constants {

    /*****************************Public Static Constant and Keys**********************************/

    String kDefaultAppName = "MilkGroceryAPp";
    String kIsFirstTime = "isFirstTime";
    String kApiVersion = "apiVersion";
    String kAppPreferences = "GroceryPreferences";

    String kGoogleClientId = "1034521322476-p7ngl17fl4plmu9qdgnskelusvqflitf.apps.googleusercontent.com";
    String kGoogleSecretClientId = "VnGyPac4viPadn8ZE8arHAlO";
    String kGoogleRedirectUrl = "https://peepsin-5406b.firebaseapp.com/__/auth/handler";
    /**********************API RequestParameters And ResponseParameters****************************/

    int REQUEST_CODE_AUTOCOMPLETE = 105;
    int REQUEST_LOCATION = 115;
    int PHOTO_RESULT = 200;
    int ADD_ADDRESS_CODE = 101;
    int FILTER_RESULT = 20;
    int ADDRESS_RESULT = 24;
    int CATEGORY_RESULT = 25;
    int SUB_CATEGORY_RESULT = 26;
    int PRODUCT_RESULT = 27;
    int GALLERY_RESULT = 102;
    int SHARE_PRODUCT = 45;
    String CART_UPDATE = "cartupdate";
    String PROGRESS_UPDATE = "progress";
    String FRAGMENT_STATE = "state";

    //API Base Key
    String kStatus = "status";
    String kMessage = "message";
    String kSuccess = "success";
    String kResult = "result";
    String kRecords = "records";
    String kRecord  ="record";
    String kPage = "page";
    String kFlag = "flag";

    String kAPNSToken = "apnsToken";
    String kCurrentUser = "currentUser";

    String kCurrentTimeStamp = "CurrentTimeStamp";
    String kTimestamp = "timeStamp";

    String kResults = "results";
    String kTotalRecords = "totalRecords";

    String kAuthToken = "authToken";
    String kGenericAuthToken = "genericAuthToken";
    String kDefaultAuthToken = "defaultAuthToken";
    String kUserId = "userId";

    String kReferralCode = "referralCode";
    String kIsReferralCodeValidated = "isReferralCodeValidated";
    String kReferralCodeMessage = "referralCodeMessage";

    String kFirstName = "firstName";
    String kLastName = "lastName";
    String kEmail = "email";
    String kPhone = "phone";
    String kGender = "gender";
    String kDateOfBirth = "dateOfBirth";
    String kPassword = "password";
    String kRegType = "regType";
    String kDeviceType = "deviceType";
    String kContactId = "contactId";
    String kContactIdType = "contactIdType";
    String kJoinedDate = "joinedDate";
    String kPrimaryAddress = "primaryAddress";
    String kUserSocialLinks = "userSocialLinks";
    String kIsAccountActivated = "isAccountActivated";
    String kIsAlreadyRegistered = "isAlreadyRegistered";

    String kSocialId = "socialId";
    String kIsNewUser = "isNewUser";
    String kIsVerified = "isVerified";
    String kIsValidate = "isValidate";
    String kRequestType = "requestType";

    // Common Constants
    String kInventoryId = "inventoryId";
    String kUserImageURL = "userImageURL";
    String kProfilePic = "profilePic";
    String kProfilePicUrl = "profilePicURL";
    String kSuggestionTag = "suggesstionTag";
    String kFormattedHtml = "formattedHTML";


    //Address constants
    String kAddress = "address";
    String kAddressId = "addressId";
    String kFullName = "fullName";
    String kStreetAddress = "streetAddress";
    String kCity = "city";
    String kState = "state";
    String kCountry = "country";
    String kZipcode = "zipCode";
    String kIsPrimary = "isPrimary";
    String kLatitude = "lat";
    String kLongitude = "long";



    //Filter Variables
    String kSortingCriteria = "sortingCriteria";
    String kAppliedFilter = "appliedFilter";
    String kPriceRange = "priceRange";
    String kRange ="range";
    String kNearByMe="nearByMe";

    //Shopping Cart
    String kTotalCartPrice = "totalCartPrice";
    String kCartItemCount = "cartItemCount";
    String kPromoCode = "promoCode";
    String kIsValid = "isValid";

    //Shopping Product
    String kProductList = "productList";
    String kTotalProductCount = "totalProductCount";
    String kCartProductName = "productName";
    String kDiscountTagLine = "discountTagLine";
    String kSpecification = "specification";

    //Products constants
    String kOtherImageURLList = "otherImageURLList";
    String kOtherImageThumbnailURLList = "otherImageThumbnailURLList";

    String kProduct = "product";
    String kProductRef = "product";
    String kProductId = "productId";
    String kName = "name";
    String kProductName = "productName";
    String kProductDesc = "description";
    String kProductImageUrl = "coverImageURL";
    String kCoverImageUrl = "coverImageURL";
    String kProductThumbUrl = "coverImageThumbnailURL";
    String kProductThumbnailURL = "productThumbnailURL";
    String kProductImageUrlList = "otherImageURLList";
    String kProductThumbUrlList = "otherImageThumbnailURLList";
    String kPostingDate = "postingDate";
    String kProductCategory = "productCategory";
    String kProductCategoryId = "productCategoryId";
    String kProductSubCategory = "productSubcategory";
    String kProductSubCategoryId = "productSubcategoryId";
    String kProductPrice = "price";
    String kProductSellPrice = "sellingPrice";
    String kProductAddress = "productAddress";
    String kFavProducts = "favoriteProducts";
    String kQuantity  = "quantity";
    String kSKUNumber = "SKUNumber";
    String kProductStatus = "productStatus";
    String kProductIdList = "productIdList";
    String kItemQuantity  = "Quantity";
    String kReasonOfFailure = "reasonOfFailure";
    String kStockStatus = "stockStatus";
    String kNetPrice = "netPrice";
    String kTotalTax = "totalTax";
    String kProductBasicPrice = "productBasicPrice";

    //Category Constants
    String kCategoryList    = "categoryList";
    String kCategoryStore   = "categoryStore";
    String kCategoryId      = "categoryId";
    String kCategory        = "category";

    //SubCategory Constants
    String kSubCategoryId = "subcategoryId";
    String kSubCategory = "subCategory";
    String ksubCategoryList ="subCategoryList";

    //Product Image constants
    String kCoverImage = "coverImage";
    String kCoverImage1 = "image1";
    String kCoverImage2 = "image2";
    String kCoverImage3 = "image3";
    String kCoverImage4 = "image4";
    String kCoverImage5 = "image5";

    //Feed and Editable
    String kFeeds = "feedList";
    String kImageUrl = "url";
    String kImagePath = "path";
    String kEditable = "editable";

    //Dialog constants
    String KSCREENWIDTH = "screenwidth";
    String KSCREENHEIGHT = "screenheight";

    //Connection Contact
    String kContactList = "contactList";
    String kContactType = "contactType";

    //Google Contact api
    String kGoogleContactsAppName = "PeepsIn";
    String kGoogleContactsEmail = "emailAddresses";
    String kGoogleContactsPhone = "phoneNumbers";
    String kGoogleContactsName = "name";
    String kGoogleContactsPhoto = "photos";

    //Facebook Contact api
    String kFacebookCommanFriends = "friends";
    String kFacebookCommanData = "data";
    String kFacebookCommanNameKey = "name";
    String kFacebookCommanIdKey = "id";
    String kFacebookCommanImageLink = "http://graph.facebook.com/";
    String kFacebookCommanImageSize = "/picture?type=large";
    String kFacebookCommanFields = "fields";
    String kFacebookCommanAllFields = "email,first_name,last_name,gender,id,link,name,friends";

    //Google map api constants
    String kPremise = "premise";
    String kStreetNumber = "street_number";
    String kRoute = "route";
    String kLocality = "locality";
    String kAdministrativeAreaLevel2 = "administrative_area_level_2";
    String kAdministrativeAreaLevel1 = "administrative_area_level_1";
    String kPostalCode = "postal_code";

    /*privacy and setting key*/

    /*Search*/
    String kSearchString = "searchString";


    /*Payment through Paytm*/
    // String kOrderId = "orderId";
    String kMID = "MID";
    String kORDER_ID = "ORDER_ID";
    String kCUST_ID = "CUST_ID";
    String kINDUSTRY_TYPE_ID = "INDUSTRY_TYPE_ID";
    String kCHANNEL_ID = "CHANNEL_ID";
    String kTXN_AMOUNT = "TXN_AMOUNT";
    String kWEBSITE = "WEBSITE";
    String kCALLBACK_URL = "CALLBACK_URL";
    String kCHECKSUMHASH = "CHECKSUMHASH";
    String kChecksumDetails = "checksumDetails";

    //Order Constants
    String kOrderList = "orderList";
    String kOrderId = "orderId";
    String kOrderStatusId = "orderStatusId";
    String kOrderStatus = "orderStatus";
    String kOrderDate = "orderDate";
    String kPaymentType = "paymentType";

    String kIsSuccessfullyCanceled = "isSuccessfullyCanceled";
    String kIsSuccessfullyRemoved = "isSuccessfullyRemoved";

    /*Final Bill Summary*/
    String kDeliveryAddress = "deliveryAddress";
    String kFProductName = "productName";
    String kPrice = "price";
    String kPromoCodeTagLine = "promoCodeTagLine";
    String kTotalCartPriceBeforePromoCode = "totalCartPriceBeforePromoCode";
    String kFinalAmountAfterPromoCode = "finalAmountAfterPromoCode";
    String kDiscountedPrice = "discountedPrice";
    String kTotalItemCount = "totalItemCount";
    String kSellingPrice = "sellingPrice";
    String kProductQuantity = "productQuantity";
    String kCoverImageThumbnailURL = "coverImageThumbnailURL";
    String kTotalAmountWithoutDiscount = "totalAmountWithoutDiscount";
    String kNetPaybaleAmount = "netPaybaleAmount";
    String kInvoiceURL = "invoiceURL";
    String kExpectedDeliveryDate = "expectedDeliveryDate";

    /**********************API RequestParameters And ResponseParameters****************************/

    String kDATABASE_NAME = "Groceries.db";

    String kSeperator = "__";
    String kEmptyString = "";
    String kWhitespace = " ";
    Number kEmptyNumber = 0;

    String kMessageInternalInconsistency = "Some internal inconsistency occurred. Please try again.";
    String kMessageNetworkError = "Device does not connect to internet.";
    String kSocketTimeOut = "PeepsIn Server not responding..";
    String kMessageServerNotRespondingError = "PeepsIn server not responding!";
    String kMessageConnecting = "Connecting...";
    String kError = "Error";

    String kErrorEmailAlreadyExist = "Email you provide already exist";
    String kErrorPhoneAlreadyExist = "Phone you provide already exist";


    /********************************File Manager constants****************************************/

    String kPlaceHolderUrl = "http://placehold.it/200x200";
    String kPlaceHolderThumbnails = "http://placehold.it/150/";

    //Push notificaitons
    String kData = "data";
    String kType = "type";
    String kId = "Id";
    String kNotification = "notification";
    String kBody = "body";
    String kTitle = "title";
    String kReload = "reload";

    String kViewType = "viewType";
    String kPictureList = "picList";
    String kSize = "size";


    String kOTP = "OTP";
    //google map contstants
    String kDistance = "distance";
    String kDuration = "duration";
    String kText = "text";

    String kShareLink="shareLink";

    //regarding the updation of app.
    String kCurrentVersion="currentVersion";
    String kBuildNumber="buildNumber";
    String kVersionNumber="versionNumber";
    String kVersionDescription="versionDescription";
    String kIsMandatoryUpdate="isMandatoryUpdate";
    String kRolloutTimestamp="rolloutTimestamp";
    String kVersionMandatoryTimestamp="versionMandatoryTimestamp";
    String kBuildType="buildType";
    String kMinOSVersion="minOSVersion";
    String kMaxOSVersion="maxOSVersion";
    String kLanguageSupported="languageSupported";


    /*****************************Public Static Constant and Keys**********************************/

    /**
     * Http Status for API Response
     */
    enum HTTPStatus {
        success(200),
        badRequest(400),
        unauthorized(401),
        notFound(404),
        methodNotAllowed(405),
        notAcceptable(406),
        proxyAuthenticationRequired(407),
        requestTimeout(408),
        error(-100);         //No option found.

        //Defination
        private int httpStatus;

        HTTPStatus(int httpStatus) {
            this.httpStatus = httpStatus;
        }

        public static HTTPStatus getStatus(int status) {
            for (HTTPStatus httpStatus : HTTPStatus.values()) {
                if (httpStatus.httpStatus == status) {
                    return httpStatus;
                }
            }
            return error;
        }

        public Integer getValue() {
            return this.httpStatus;
        }
    }

    /**
     * Status Enumration for Task Status
     */
    enum Status {
        success(0),
        fail(1),
        reachLimit(2),
        noChange(3),
        history(4),            //If xmpp message is history
        normal(5),            //If Normal xmpp message
        discard(6);

        //Defination
        private int value;

        Status(int status) {
            this.value = status;
        }

        public static Status getStatus(int value) {
            for (Status status : Status.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            return fail;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }


    /**
     * This enum is used for order status
     */
    enum OrderStatus {
        newOrder(1),
        inProgress(2),
        outDelivery(3),
        delivered(4),
        cancelled(5),
        declined(6),
        returned(7);

        private int value;

        OrderStatus(int value) {
            this.value = value;
        }

        /**
         * Convert int to Gender Type
         */
        public static OrderStatus getMessageType(int value) {
            for (OrderStatus orderStatus : OrderStatus.values()) {
                if (orderStatus.value == value) {
                    return orderStatus;
                }
            }
            return newOrder;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum Gender {
        male(1),
        female(2),
        other(3);
        //Defination
        private int value;

        Gender(int gender) {
            this.value = gender;
        }

        /**
         * Convert int to Gender Type
         */
        public static Gender getGender(int value) {
            for (Gender gender : Gender.values()) {
                if (gender.value == value) {
                    return gender;
                }
            }
            return male;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum UserRegType {
        system(1),
        facebook(2),
        google(3),
        twitter(4);

        private int value;

        UserRegType(int regType) {
            this.value = regType;
        }

        /**
         * Convert int to UserRegType Type
         */
        public static UserRegType getRegType(int value) {
            for (UserRegType regType : UserRegType.values()) {
                if (regType.value == value) {
                    return regType;
                }
            }
            return system;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum ContactType {
        system(1),
        facebook(2),
        google(3),
        twitter(4),
        phone(5);

        private int value;

        ContactType(int contactType) {
            this.value = contactType;
        }

        /**
         * Convert int to DeviceType Type
         */
        public static ContactType getContactType(int value) {
            for (ContactType contactType : ContactType.values()) {
                if (contactType.value == value) {
                    return contactType;
                }
            }
            return system;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum GeoAddressType {
        premise(1),
        street_number(2),
        route(3),
        locality(4),
        administrative_area_level_2(5),
        administrative_area_level_1(6),
        country(7),
        postal_code(8);

        private int value;

        GeoAddressType(int deviceType) {
            this.value = deviceType;
        }

        /**
         * Convert int to DeviceType Type
         */
        public static GeoAddressType geoAddressType(int value) {
            for (GeoAddressType geoAddressType : GeoAddressType.values()) {
                if (geoAddressType.value == value) {
                    return geoAddressType;
                }
            }
            return premise;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }

    }


}