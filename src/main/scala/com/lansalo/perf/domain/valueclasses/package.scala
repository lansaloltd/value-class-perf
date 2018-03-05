package com.lansalo.perf.domain

package object valueclasses {

  final case class Price(price: Double)

  case class PriceVal(price: Double) extends AnyVal {
    def -(that: PriceVal) = PriceVal(this.price - that.price)
    def +(that: PriceVal) = PriceVal(this.price + that.price)
  }

  final case class Item(itemId: Int, asked: Double, soldPrice: Double)

  final case class ItemBad(itemId: Int, asked: Price, soldPrice: Price)

  final case class ItemGood(itemId: Int, asked: PriceVal, soldPrice: PriceVal)

}
