package com.ebayk.domain.usecase.retrieveads

import com.ebayk.FakeDataProvider
import com.ebayk.ads.data.RetrieveAdsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


internal class RetrieveAdsUseCaseTest{

    @MockK
    private lateinit var notesRepository: com.ebayk.ads.data.RetrieveAdsRepository

    private lateinit var retrieveAdsUseCase: com.ebayk.ads.domain.RetrieveAdsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        retrieveAdsUseCase = com.ebayk.ads.domain.RetrieveAdsUseCase(notesRepository)
    }

    @Test
    fun `test when involk getNotes should call getNotes from the repo`() {
        //setUp
        coEvery {
            notesRepository.requestAds("test")
        } returns FakeDataProvider.provideFakeAdsModel()

        //when
        //run suspended test function
        runTest {
            val notesResult = retrieveAdsUseCase.invoke("1118635128")

            //then
            coVerify(exactly = 1) { notesRepository.requestAds("test") }
            //assertion
            assertEquals(FakeDataProvider.provideFakeAdsModel(), notesResult)
        }
    }

}