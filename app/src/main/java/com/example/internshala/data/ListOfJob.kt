package com.example.internshala.data

import com.example.internshala.R
import com.example.internshala.data.model.Job
import com.example.internshala.data.model.PlacementDescription
import com.example.internshala.data.model.PlacementOpportunity

object ListOfJob {
    val list = listOf(
        PlacementOpportunity(
            activelyHiring = true, requiredExperience = "1-2 years",
            jobDesignation = "Android App Development",
            jobLocation = "Bangalore",
            companyName = "Google",
            companyLogo = R.drawable.google_icon,
            id = 1,
            salary = "15,00,000 - 16,00,000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "3 hours ago",
            opportunityType = "job",
            jobDescription = 
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 1,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since August 2016",
                    postedOpportunities = 1352,
                    hiredCandidates = 1210,
                    applicants = 25521,
                    lastDateToApply = "30 July"
                )
        ),
        PlacementOpportunity(
            activelyHiring = true,
            requiredExperience = "2 years",
            jobDesignation = "Product Management Intern",
            jobLocation = "Mumbai",
            companyName = "Reliance",
            companyLogo = R.drawable.reliance_icon,
            id = 2,
            salary = "30000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "4 hours ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 1,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since December 2014",
                    postedOpportunities = 623,
                    hiredCandidates = 578,
                    applicants = 2516,
                    lastDateToApply = "10 July"
                )
        ),
        PlacementOpportunity(
            activelyHiring = true,
            requiredExperience = "3 years",
            jobDesignation = "Bluetooth Developer",
            jobLocation = "Noida",
            companyName = "Samsung",
            companyLogo = R.drawable.samsung_icon,
            id = 3,
            salary = "8,00,000 - 9,00,000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "6 hours ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 6,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since November 2020",
                    postedOpportunities = 269,
                    hiredCandidates = 169,
                    applicants = 669,
                    lastDateToApply = "16 July"
                )
        ),
        PlacementOpportunity(activelyHiring = true, requiredExperience = "1 years",
            jobDesignation = "Solution Architect",
            jobLocation = "Hyderabad",
            companyName = "Airtel",
            companyLogo = R.drawable.airtel_icon,
            id = 4,
            salary = "12,00,000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "7 hours ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 2,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since December 2019",
                    postedOpportunities = 129,
                    hiredCandidates = 111,
                    applicants = 2516,
                    lastDateToApply = "20 July"
                )
        ),
        PlacementOpportunity(activelyHiring = true, requiredExperience = "1 year",
            jobDesignation = "React Native Developer",
            jobLocation = "Bangalore",
            companyName = "Meta",
            companyLogo = R.drawable.meta_icon,
            id = 5,
            salary = "8,00,0000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "8 hours ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 3,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since March 2018",
                    postedOpportunities = 874,
                    hiredCandidates = 789,
                    applicants = 8340,
                    lastDateToApply = "12 July"
                )
        ),
        PlacementOpportunity(activelyHiring = false,
            requiredExperience = "0-6 months",
            jobDesignation = "Field Sales Trainee",
            jobLocation = "Delhi",
            companyName = "Swiggy",
            companyLogo = R.drawable.swiggy_icon,
            id = 6,
            salary = "1,50,000 - 2,00,000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "10 hours ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 1,
                    perks = listOf("Certificate"),
                    companyRegistrationDate = "Hiring Since October 2022",
                    postedOpportunities = 163,
                    hiredCandidates = 121,
                    applicants = 324,
                    lastDateToApply = "21 July"
                )
        ),
        PlacementOpportunity(activelyHiring = true, requiredExperience = "4 years",
            jobDesignation = "Data Analyst",
            jobLocation = "Gurgaon",
            companyName = "Instagram",
            companyLogo = R.drawable.instagram_icon,
            id = 7,
            salary = "20,00,000",
            suggestion = "Job",
            postedTime = 'h',
            datePosted = "12 hours ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 8,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since June 2020",
                    postedOpportunities = 786,
                    hiredCandidates = 669,
                    applicants = 4244,
                    lastDateToApply = "26 July"
                )
        ),
        PlacementOpportunity(activelyHiring = true, requiredExperience = "4+ years",
            jobDesignation = "Java Developer",
            jobLocation = "Delhi",
            companyName = "Tata Consultancy Services",
            companyLogo = R.drawable.tcs_icon,
            id = 8,
            salary = "6,00,000 - 7,00,000",
            suggestion = "Job",
            postedTime = 'w',
            datePosted = "1 week ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 620,
                    perks = listOf("Free Snacks"),
                    companyRegistrationDate = "Hiring Since February 2014",
                    postedOpportunities = 8543,
                    hiredCandidates = 7632,
                    applicants = 4589,
                    lastDateToApply = "7 August"
                )
        ),
        PlacementOpportunity(activelyHiring = true, requiredExperience = "5+ years",
            jobDesignation = "Human Resource Associate",
            jobLocation = "Mumbai",
            companyName = "J.P Morgan",
            companyLogo = R.drawable.jpmorgan_icon,
            id = 9,
            salary = "12,00,000",
            suggestion = "Job",
            postedTime = 'w',
            datePosted = "1 week ago",
            opportunityType = "job",
            jobDescription =
                PlacementDescription(
                    aboutEmployer = R.string.about_google,
                    aboutPlacement =  R.string.google_job,
                    eligibility = R.string.google_eligibility,
                    additionalInformation = R.string.google_additional_information,
                    numberOfOpenings = 3,
                    perks = listOf("Offer letter","Free Snacks","kick start your youtube career"),
                    companyRegistrationDate = "Hiring Since December 2019",
                    postedOpportunities = 679,
                    hiredCandidates = 584,
                    applicants = 5428,
                    lastDateToApply = "28 July"
                )
        ),
        PlacementOpportunity(activelyHiring = true, requiredExperience = "2+ years",
            jobDesignation = "Software Development Engineer (Android)",
            jobLocation = "Gurgaon",
            companyName = "Internshala",
            companyLogo = R.drawable.internshala_icon,
            id = 10,
            salary = "5,00,000 - 6,00,000",
            suggestion = "Job",
            postedTime = 'w',
            datePosted = "2 weeks ago",
            opportunityType = "job",
            jobDescription =
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