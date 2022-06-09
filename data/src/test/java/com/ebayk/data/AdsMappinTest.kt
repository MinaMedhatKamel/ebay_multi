package com.ebayk.data

import Address
import Attribute
import com.ebayk.data.model.DetailsItem
import junit.framework.Assert
import junit.framework.TestCase.assertEquals
import org.junit.Test
import toDetailsItem
import toFormattedAddress

class AdsMappinTest {

    val mockedAddressStr = "testStreet, 12345 city"
    val mockeddDetailsObj1 = DetailsItem("label", "15")
    val mockeddDetailsObj2 = DetailsItem("label", "15m2")

    @Test
    fun `test mapping address`() {
        val address: Address = Address("city", "test", "test", "testStreet", "12345")
        Assert.assertEquals(address.toFormattedAddress(), mockedAddressStr)
    }

    @Test
    fun `test details items when attributes unit is null`() {
        val attribute = Attribute("label", null, "15")
        assertEquals(attribute.toDetailsItem(), mockeddDetailsObj1)
    }

    @Test
    fun `test details items when attributes unit is not null`() {
        val attribute = Attribute("label", "m2", "15")
        assertEquals(attribute.toDetailsItem(), mockeddDetailsObj2)
    }
}