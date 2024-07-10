package com.example.internshala.data

import com.example.internshala.R
import com.example.internshala.data.model.PlacementOpportunity
import com.example.internshala.data.model.PlacementDescription

object PreferenceList {
    val list   = listOf(
        PlacementOpportunity(
            activelyHiring = true,
            jobDesignation = "Data Structures and Algorithms (DSA) Mentor",
            jobLocation = "Work form home",
            companyName = "DevTown",
            id = 11,
            stipend = "40,000",
            duration = 6,
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 5,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since December 2016",
                    postedOpportunities = 127,
                    hiredCandidates = 114,
                    applicants = 320,
                    lastDateToApply = "14 July"

                )
        ),
        PlacementOpportunity(
            activelyHiring = true,
            jobDesignation = "Front End Development",
            jobLocation = "Work from Home",
            companyName = "Lunacal",
            id = 12,
            duration = 4,
            stipend = "30,000",
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 5,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since December 2019",
                    postedOpportunities = 221,
                    hiredCandidates = 156,
                    applicants = 789,
                    lastDateToApply = "16 July"
                )
        ),
        PlacementOpportunity(
            activelyHiring = true,
            jobDesignation = "Django Backend & Data Engineer ",
            jobLocation = "Bangalore",
            companyName = "Primenumbers Technologies",
            id = 13,
            duration = 6,
            stipend = "30,000",
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 5,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since October 2023",
                    postedOpportunities = 15,
                    hiredCandidates = 12,
                    applicants = 56,
                    lastDateToApply = "12 July"
                )
        ),
        PlacementOpportunity(activelyHiring = true,
            jobDesignation = "Machine Learning",
            jobLocation = "Work from Home",
            companyName = "Alemeno",
            id = 14,
            duration = 3,
            stipend = "20,000-30,000",
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 5,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since January 2024",
                    postedOpportunities = 21,
                    hiredCandidates = 18,
                    applicants = 34,
                    lastDateToApply = "21 July"
                )

        ),
        PlacementOpportunity(activelyHiring = true,
            jobDesignation = "Java Development",
            jobLocation = "Work from home",
            companyName = "CloudEagle",
            id = 15,
            duration = 3,
            stipend = "25,000",
            suggestion = "Internship with job offer",
            postedTime = 'h',
            datePosted = "8 hours ago",
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 5,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since January 2018",
                    postedOpportunities = 123,
                    hiredCandidates = 89,
                    applicants = 254,
                    lastDateToApply = "19 July"
                )

        ),
        PlacementOpportunity(activelyHiring = false,
            jobDesignation = "Artificial Intelligence (AI)",
            jobLocation = "Delhi",
            companyName = "Induct Finance (Quasar Pulse Technology Private Limited)",
            id = 16,
            stipend = "25,000",
            duration = 2,
            suggestion = "Internship",
            postedTime = 'h',
            datePosted = "10 hours ago",
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 1,
                    perks = listOf("Certificate"),
                    companyRegistrationDate = "Hiring Since March 2022",
                    postedOpportunities = 23,
                    hiredCandidates = 11,
                    applicants = 12,
                    lastDateToApply = "13 July"
                )

        ),
        PlacementOpportunity(activelyHiring = true,
            jobDesignation = "Data Analyst",
            jobLocation = "Gurgaon",
            companyName = "Instagram",
            companyLogo = R.drawable.instagram_icon,
            id = 7,
            stipend = "60,000",
            duration = 6,
            suggestion = "Internship with job offer",
            postedTime = 'h',
            datePosted = "12 hours ago",
            opportunityType = "internship",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 5,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since June 2020",
                    postedOpportunities = 786,
                    hiredCandidates = 669,
                    applicants = 4244,
                    lastDateToApply = "26 July"
                )

        ),
        PlacementOpportunity(activelyHiring = true,
            jobDesignation = "Java Developer",
            jobLocation = "Delhi",
            companyName = "Tata Consultancy Services",
            companyLogo = R.drawable.tcs_icon,
            id = 8,
            duration = 3,
            stipend = "20000",
            suggestion = "Internship",
            postedTime = 'w',
            datePosted = "1 week ago",
            opportunityType = "internship", jobDescription =
            PlacementDescription(
                aboutEmployer = R.string.about_google,
                aboutPlacement =  R.string.google_job,
                eligibility = R.string.google_eligibility,
                additionalInformation = R.string.google_additional_information,
                numberOfOpenings = 5,
                perks = listOf("Free Snacks"),
                companyRegistrationDate = "Hiring Since February 2014",
                postedOpportunities = 8543,
                hiredCandidates = 7632,
                applicants = 4589,
                lastDateToApply = "7 August"
            )

        ),
        PlacementOpportunity(activelyHiring = true,
            jobDesignation = "Human Resource Associate",
            jobLocation = "Mumbai",
            companyName = "J.P Morgan",
            companyLogo = R.drawable.jpmorgan_icon,
            id = 9,
            stipend = "25000",
            duration = 6,
            suggestion = "Internship with job offer",
            postedTime = 'w',
            datePosted = "1 week ago",
            opportunityType = "internship", jobDescription =
            PlacementDescription(
                aboutEmployer = R.string.about_google,
                aboutPlacement =  R.string.google_job,
                eligibility = R.string.google_eligibility,
                additionalInformation = R.string.google_additional_information,
                numberOfOpenings = 5,
                perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                companyRegistrationDate = "Hiring Since December 2019",
                postedOpportunities = 679,
                hiredCandidates = 584,
                applicants = 5428,
                lastDateToApply = "28 July"
            )

        ),
        PlacementOpportunity(activelyHiring = true,
            jobDesignation = "Software Development Engineer (Android)",
            jobLocation = "Gurgaon",
            companyName = "Internshala",
            companyLogo = R.drawable.internshala_icon,
            id = 10,
            stipend = "18000",
            duration = 6,
            suggestion = "Internship",
            postedTime = 'w',
            datePosted = "2 weeks ago",
            opportunityType = "internship", jobDescription =
            PlacementDescription(
                aboutEmployer = R.string.about_google,
                aboutPlacement =  R.string.google_job,
                eligibility = R.string.google_eligibility,
                additionalInformation = R.string.google_additional_information,
                numberOfOpenings = 1,
                perks = listOf("Informal Dress Code","5 days a week"),
                companyRegistrationDate = "Hiring Since December 2016",
                postedOpportunities = 227,
                hiredCandidates = 214,
                applicants = 921,
                lastDateToApply = "14 July"
            )
        )
    )
}