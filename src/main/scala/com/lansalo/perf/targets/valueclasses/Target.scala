package com.lansalo.perf.targets

import com.lansalo.perf.domain.valueclasses._

package object valueclasses {

  def totalPerformanceA(list: List[Item]): Double = {
    list.foldLeft(0d)((acc, item) => {item.soldPrice - item.asked})
  }

  def totalPerformanceB(list: List[ItemBad]): Double = {
    list.foldLeft(0d)((acc, item) => { item.soldPrice.price - item.asked.price })
  }

  def totalPerformanceC(list: List[ItemGood]): PriceVal = {
    list.foldLeft(PriceVal(0d))((acc, item) => { item.soldPrice - item.asked })
  }

  def instantiateA(list: List[Int]): List[Item] = {
    list.map(n => Item(n, n, n + 1.0))
  }

  def instantiateB(list: List[Int]): List[ItemBad] = {
    list.map(n => ItemBad(n, Price(n), Price(n + 1.0)))
  }

  def instantiateC(list: List[Int]): List[ItemGood] = {
    list.map(n => ItemGood(n, PriceVal(n), PriceVal(n + 1.0)))
  }

}