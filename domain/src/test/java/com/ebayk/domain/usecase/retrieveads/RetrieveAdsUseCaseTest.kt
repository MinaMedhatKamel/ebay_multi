package com.ebayk.domain.usecase.retrieveads

import com.ebayk.FakeDataProvider
import com.ebayk.data.repository.RetrieveAdsRepository
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
    private lateinit var notesRepository: RetrieveAdsRepository

    private lateinit var retrieveAdsUseCase: RetrieveAdsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        retrieveAdsUseCase = RetrieveAdsUseCase(notesRepository)
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