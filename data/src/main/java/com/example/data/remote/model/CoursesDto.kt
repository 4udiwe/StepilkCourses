package com.example.data.remote.model


import com.example.domain.model.Course
import com.google.gson.annotations.SerializedName


data class CoursesDto(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("summary") var summary: String? = null,
    @SerializedName("workload") var workload: String? = null,
    @SerializedName("cover") var cover: String? = null,
    @SerializedName("intro") var intro: String? = null,
    @SerializedName("course_format") var courseFormat: String? = null,
    @SerializedName("target_audience") var targetAudience: String? = null,
    @SerializedName("certificate_footer") var certificateFooter: String? = null,
    @SerializedName("certificate_cover_org") var certificateCoverOrg: String? = null,
    @SerializedName("is_certificate_issued") var isCertificateIssued: Boolean? = null,
    @SerializedName("is_certificate_auto_issued") var isCertificateAutoIssued: Boolean? = null,
    @SerializedName("certificate_regular_threshold") var certificateRegularThreshold: String? = null,
    @SerializedName("certificate_distinction_threshold") var certificateDistinctionThreshold: String? = null,
    @SerializedName("instructors") var instructors: ArrayList<Int> = arrayListOf(),
    @SerializedName("certificate") var certificate: String? = null,
    @SerializedName("requirements") var requirements: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("sections") var sections: ArrayList<Int> = arrayListOf(),
    @SerializedName("total_units") var totalUnits: Int? = null,
    @SerializedName("enrollment") var enrollment: String? = null,
    @SerializedName("is_favorite") var isFavorite: Boolean? = null,
    @SerializedName("actions") var actions: ActionsDto? = ActionsDto(),
    @SerializedName("progress") var progress: String? = null,
    @SerializedName("first_lesson") var firstLesson: Int? = null,
    @SerializedName("first_unit") var firstUnit: Int? = null,
    @SerializedName("certificate_link") var certificateLink: String? = null,
    @SerializedName("certificate_regular_link") var certificateRegularLink: String? = null,
    @SerializedName("certificate_distinction_link") var certificateDistinctionLink: String? = null,
    @SerializedName("user_certificate") var userCertificate: String? = null,
    @SerializedName("referral_link") var referralLink: String? = null,
    @SerializedName("schedule_link") var scheduleLink: String? = null,
    @SerializedName("schedule_long_link") var scheduleLongLink: String? = null,
    @SerializedName("first_deadline") var firstDeadline: String? = null,
    @SerializedName("last_deadline") var lastDeadline: String? = null,
    @SerializedName("subscriptions") var subscriptions: ArrayList<String> = arrayListOf(),
    @SerializedName("announcements") var announcements: ArrayList<String> = arrayListOf(),
    @SerializedName("is_contest") var isContest: Boolean? = null,
    @SerializedName("is_self_paced") var isSelfPaced: Boolean? = null,
    @SerializedName("is_adaptive") var isAdaptive: Boolean? = null,
    @SerializedName("is_idea_compatible") var isIdeaCompatible: Boolean? = null,
    @SerializedName("is_in_wishlist") var isInWishlist: Boolean? = null,
    @SerializedName("last_step") var lastStep: String? = null,
    @SerializedName("intro_video") var introVideo: IntroVideoDto? = null,
    @SerializedName("social_providers") var socialProviders: ArrayList<String> = arrayListOf(),
    @SerializedName("authors") var authors: ArrayList<Int> = arrayListOf(),
    @SerializedName("tags") var tags: ArrayList<Int> = arrayListOf(),
    @SerializedName("has_tutors") var hasTutors: Boolean? = null,
    @SerializedName("is_enabled") var isEnabled: Boolean? = null,
    @SerializedName("is_proctored") var isProctored: Boolean? = null,
    @SerializedName("proctor_url") var proctorUrl: String? = null,
    @SerializedName("review_summary") var reviewSummary: Int? = null,
    @SerializedName("schedule_type") var scheduleType: String? = null,
    @SerializedName("certificates_count") var certificatesCount: Int? = null,
    @SerializedName("learners_count") var learnersCount: Int? = null,
    @SerializedName("lessons_count") var lessonsCount: Int? = null,
    @SerializedName("quizzes_count") var quizzesCount: Int? = null,
    @SerializedName("challenges_count") var challengesCount: Int? = null,
    @SerializedName("peer_reviews_count") var peerReviewsCount: Int? = null,
    @SerializedName("instructor_reviews_count") var instructorReviewsCount: Int? = null,
    @SerializedName("videos_duration") var videosDuration: Int? = null,
    @SerializedName("time_to_complete") var timeToComplete: String? = null,
    @SerializedName("is_popular") var isPopular: Boolean? = null,
    @SerializedName("is_processed_with_paddle") var isProcessedWithPaddle: Boolean? = null,
    @SerializedName("is_unsuitable") var isUnsuitable: Boolean? = null,
    @SerializedName("is_paid") var isPaid: Boolean? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("currency_code") var currencyCode: String? = null,
    @SerializedName("display_price") var displayPrice: String? = null,
    @SerializedName("default_promo_code_name") var defaultPromoCodeName: String? = null,
    @SerializedName("default_promo_code_price") var defaultPromoCodePrice: String? = null,
    @SerializedName("default_promo_code_discount") var defaultPromoCodeDiscount: String? = null,
    @SerializedName("default_promo_code_is_percent_discount") var defaultPromoCodeIsPercentDiscount: String? = null,
    @SerializedName("default_promo_code_expire_date") var defaultPromoCodeExpireDate: String? = null,
    @SerializedName("continue_url") var continueUrl: String? = null,
    @SerializedName("readiness") var readiness: Double? = null,
    @SerializedName("is_archived") var isArchived: Boolean? = null,
    @SerializedName("options") var options: OptionsDto? = OptionsDto(),
    @SerializedName("price_tier") var priceTier: String? = null,
    @SerializedName("position") var position: Int? = null,
    @SerializedName("is_censored") var isCensored: Boolean? = null,
    @SerializedName("difficulty") var difficulty: String? = null,
    @SerializedName("acquired_skills") var acquiredSkills: ArrayList<String> = arrayListOf(),
    @SerializedName("acquired_assets") var acquiredAssets: ArrayList<String> = arrayListOf(),
    @SerializedName("learning_format") var learningFormat: String? = null,
    @SerializedName("content_details") var contentDetails: ArrayList<String> = arrayListOf(),
    @SerializedName("issue") var issue: String? = null,
    @SerializedName("course_type") var courseType: String? = null,
    @SerializedName("possible_type") var possibleType: String? = null,
    @SerializedName("is_certificate_with_score") var isCertificateWithScore: Boolean? = null,
    @SerializedName("preview_lesson") var previewLesson: String? = null,
    @SerializedName("preview_unit") var previewUnit: String? = null,
    @SerializedName("possible_currencies") var possibleCurrencies: ArrayList<String> = arrayListOf(),
    @SerializedName("commission_basic") var commissionBasic: String? = null,
    @SerializedName("commission_promo") var commissionPromo: String? = null,
    @SerializedName("with_certificate") var withCertificate: Boolean? = null,
    @SerializedName("child_courses") var childCourses: ArrayList<String> = arrayListOf(),
    @SerializedName("child_courses_count") var childCoursesCount: Int? = null,
    @SerializedName("parent_courses") var parentCourses: ArrayList<String> = arrayListOf(),
    @SerializedName("became_published_at") var becamePublishedAt: String? = null,
    @SerializedName("became_paid_at") var becamePaidAt: String? = null,
    @SerializedName("title_en") var titleEn: String? = null,
    @SerializedName("last_update_price_date") var lastUpdatePriceDate: String? = null,
    @SerializedName("owner") var owner: Int? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("is_featured") var isFeatured: Boolean? = null,
    @SerializedName("is_public") var isPublic: Boolean? = null,
    @SerializedName("canonical_url") var canonicalUrl: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("begin_date") var beginDate: String? = null,
    @SerializedName("end_date") var endDate: String? = null,
    @SerializedName("soft_deadline") var softDeadline: String? = null,
    @SerializedName("hard_deadline") var hardDeadline: String? = null,
    @SerializedName("grading_policy") var gradingPolicy: String? = null,
    @SerializedName("begin_date_source") var beginDateSource: String? = null,
    @SerializedName("end_date_source") var endDateSource: String? = null,
    @SerializedName("soft_deadline_source") var softDeadlineSource: String? = null,
    @SerializedName("hard_deadline_source") var hardDeadlineSource: String? = null,
    @SerializedName("grading_policy_source") var gradingPolicySource: String? = null,
    @SerializedName("is_active") var isActive: Boolean? = null,
    @SerializedName("create_date") var createDate: String? = null,
    @SerializedName("update_date") var updateDate: String? = null,
    @SerializedName("learners_group") var learnersGroup: String? = null,
    @SerializedName("testers_group") var testersGroup: String? = null,
    @SerializedName("moderators_group") var moderatorsGroup: String? = null,
    @SerializedName("assistants_group") var assistantsGroup: String? = null,
    @SerializedName("teachers_group") var teachersGroup: String? = null,
    @SerializedName("admins_group") var adminsGroup: String? = null,
    @SerializedName("discussions_count") var discussionsCount: Int? = null,
    @SerializedName("discussion_proxy") var discussionProxy: String? = null,
    @SerializedName("discussion_threads") var discussionThreads: ArrayList<String> = arrayListOf(),
    @SerializedName("lti_consumer_key") var ltiConsumerKey: String? = null,
    @SerializedName("lti_secret_key") var ltiSecretKey: String? = null,
    @SerializedName("lti_private_profile") var ltiPrivateProfile: Boolean? = null

) {
    fun mapDomain() = Course(
        id,
        summary,
        workload,
        cover,
        intro,
        courseFormat,
        targetAudience,
        certificateFooter,
        certificateCoverOrg,
        isCertificateIssued,
        isCertificateAutoIssued,
        certificateRegularThreshold,
        certificateDistinctionThreshold,
        instructors,
        certificate,
        requirements,
        description,
        sections,
        totalUnits,
        enrollment,
        isFavorite,
        actions?.mapDomain(),
        progress,
        firstLesson,
        firstUnit,
        certificateLink,
        certificateRegularLink,
        certificateDistinctionLink,
        userCertificate,
        referralLink,
        scheduleLink,
        scheduleLongLink,
        firstDeadline,
        lastDeadline,
        subscriptions,
        announcements,
        isContest,
        isSelfPaced,
        isAdaptive,
        isIdeaCompatible,
        isInWishlist,
        lastStep,
        introVideo?.mapDomain(),
        socialProviders,
        authors,
        tags,
        hasTutors,
        isEnabled,
        isProctored,
        proctorUrl,
        reviewSummary,
        scheduleType,
        certificatesCount,
        learnersCount,
        lessonsCount,
        quizzesCount,
        challengesCount,
        peerReviewsCount,
        instructorReviewsCount,
        videosDuration,
        timeToComplete,
        isPopular,
        isProcessedWithPaddle,
        isUnsuitable,
        isPaid,
        price,
        currencyCode,
        displayPrice,
        defaultPromoCodeName,
        defaultPromoCodePrice,
        defaultPromoCodeDiscount,
        defaultPromoCodeIsPercentDiscount,
        defaultPromoCodeExpireDate,
        continueUrl,
        readiness,
        isArchived,
        options?.mapDomain(),
        priceTier,
        position,
        isCensored,
        difficulty,
        acquiredSkills,
        acquiredAssets,
        learningFormat,
        contentDetails,
        issue,
        courseType,
        possibleType,
        isCertificateWithScore,
        previewLesson,
        previewUnit,
        possibleCurrencies,
        commissionBasic,
        commissionPromo,
        withCertificate,
        childCourses,
        childCoursesCount,
        parentCourses,
        becamePublishedAt,
        becamePaidAt,
        titleEn,
        lastUpdatePriceDate,
        owner,
        language,
        isFeatured,
        isPublic,
        canonicalUrl,
        title,
        slug,
        beginDate,
        endDate,
        softDeadline,
        hardDeadline,
        gradingPolicy,
        beginDateSource,
        endDateSource,
        softDeadlineSource,
        hardDeadlineSource,
        gradingPolicySource,
        isActive,
        createDate,
        updateDate,
        learnersGroup,
        testersGroup,
        moderatorsGroup,
        assistantsGroup,
        teachersGroup,
        adminsGroup,
        discussionsCount,
        discussionProxy,
        discussionThreads,
        ltiConsumerKey,
        ltiSecretKey,
        ltiPrivateProfile,
    )
}