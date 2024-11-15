package com.example.domain.model


data class Courses(

    var id: Int? = null,
    var summary: String? = null,
    var workload: String? = null,
    var cover: String? = null,
    var intro: String? = null,
    var courseFormat: String? = null,
    var targetAudience: String? = null,
    var certificateFooter: String? = null,
    var certificateCoverOrg: String? = null,
    var isCertificateIssued: Boolean? = null,
    var isCertificateAutoIssued: Boolean? = null,
    var certificateRegularThreshold: String? = null,
    var certificateDistinctionThreshold: String? = null,
    var instructors: ArrayList<Int> = arrayListOf(),
    var certificate: String? = null,
    var requirements: String? = null,
    var description: String? = null,
    var sections: ArrayList<Int> = arrayListOf(),
    var totalUnits: Int? = null,
    var enrollment: String? = null,
    var isFavorite: Boolean? = null,
    var actions: Actions? = Actions(),
    var progress: String? = null,
    var firstLesson: Int? = null,
    var firstUnit: Int? = null,
    var certificateLink: String? = null,
    var certificateRegularLink: String? = null,
    var certificateDistinctionLink: String? = null,
    var userCertificate: String? = null,
    var referralLink: String? = null,
    var scheduleLink: String? = null,
    var scheduleLongLink: String? = null,
    var firstDeadline: String? = null,
    var lastDeadline: String? = null,
    var subscriptions: ArrayList<String> = arrayListOf(),
    var announcements: ArrayList<String> = arrayListOf(),
    var isContest: Boolean? = null,
    var isSelfPaced: Boolean? = null,
    var isAdaptive: Boolean? = null,
    var isIdeaCompatible: Boolean? = null,
    var isInWishlist: Boolean? = null,
    var lastStep: String? = null,
    var introVideo: IntroVideo? = null,
    var socialProviders: ArrayList<String> = arrayListOf(),
    var authors: ArrayList<Int> = arrayListOf(),
    var tags: ArrayList<Int> = arrayListOf(),
    var hasTutors: Boolean? = null,
    var isEnabled: Boolean? = null,
    var isProctored: Boolean? = null,
    var proctorUrl: String? = null,
    var reviewSummary: Int? = null,
    var scheduleType: String? = null,
    var certificatesCount: Int? = null,
    var learnersCount: Int? = null,
    var lessonsCount: Int? = null,
    var quizzesCount: Int? = null,
    var challengesCount: Int? = null,
    var peerReviewsCount: Int? = null,
    var instructorReviewsCount: Int? = null,
    var videosDuration: Int? = null,
    var timeToComplete: String? = null,
    var isPopular: Boolean? = null,
    var isProcessedWithPaddle: Boolean? = null,
    var isUnsuitable: Boolean? = null,
    var isPaid: Boolean? = null,
    var price: String? = null,
    var currencyCode: String? = null,
    var displayPrice: String? = null,
    var defaultPromoCodeName: String? = null,
    var defaultPromoCodePrice: String? = null,
    var defaultPromoCodeDiscount: String? = null,
    var defaultPromoCodeIsPercentDiscount: String? = null,
    var defaultPromoCodeExpireDate: String? = null,
    var continueUrl: String? = null,
    var readiness: Double? = null,
    var isArchived: Boolean? = null,
    var options: Options? = Options(),
    var priceTier: String? = null,
    var position: Int? = null,
    var isCensored: Boolean? = null,
    var difficulty: String? = null,
    var acquiredSkills: ArrayList<String> = arrayListOf(),
    var acquiredAssets: ArrayList<String> = arrayListOf(),
    var learningFormat: String? = null,
    var contentDetails: ArrayList<String> = arrayListOf(),
    var issue: String? = null,
    var courseType: String? = null,
    var possibleType: String? = null,
    var isCertificateWithScore: Boolean? = null,
    var previewLesson: String? = null,
    var previewUnit: String? = null,
    var possibleCurrencies: ArrayList<String> = arrayListOf(),
    var commissionBasic: String? = null,
    var commissionPromo: String? = null,
    var withCertificate: Boolean? = null,
    var childCourses: ArrayList<String> = arrayListOf(),
    var childCoursesCount: Int? = null,
    var parentCourses: ArrayList<String> = arrayListOf(),
    var becamePublishedAt: String? = null,
    var becamePaidAt: String? = null,
    var titleEn: String? = null,
    var lastUpdatePriceDate: String? = null,
    var owner: Int? = null,
    var language: String? = null,
    var isFeatured: Boolean? = null,
    var isPublic: Boolean? = null,
    var canonicalUrl: String? = null,
    var title: String? = null,
    var slug: String? = null,
    var beginDate: String? = null,
    var endDate: String? = null,
    var softDeadline: String? = null,
    var hardDeadline: String? = null,
    var gradingPolicy: String? = null,
    var beginDateSource: String? = null,
    var endDateSource: String? = null,
    var softDeadlineSource: String? = null,
    var hardDeadlineSource: String? = null,
    var gradingPolicySource: String? = null,
    var isActive: Boolean? = null,
    var createDate: String? = null,
    var updateDate: String? = null,
    var learnersGroup: String? = null,
    var testersGroup: String? = null,
    var moderatorsGroup: String? = null,
    var assistantsGroup: String? = null,
    var teachersGroup: String? = null,
    var adminsGroup: String? = null,
    var discussionsCount: Int? = null,
    var discussionProxy: String? = null,
    var discussionThreads: ArrayList<String> = arrayListOf(),
    var ltiConsumerKey: String? = null,
    var ltiSecretKey: String? = null,
    var ltiPrivateProfile: Boolean? = null

)