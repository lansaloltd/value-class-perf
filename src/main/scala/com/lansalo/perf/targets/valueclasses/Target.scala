package com.lansalo.perf.targets

import com.lansalo.perf.domain.valueclasses._

package object valueclasses {

  def totalPerformanceBase(list: List[Item]): Double = {
    list.foldLeft(0d)((acc, item) => {acc + (item.soldPrice - item.asked)})
  }

  def totalPerformanceBad(list: List[ItemBad]): Double = {
    list.foldLeft(0d)((acc, item) => {acc + (item.soldPrice.price - item.asked.price )})
  }

  def totalPerformanceGood(list: List[ItemGood]): PriceVal = {
    list.foldLeft(PriceVal(0d))((acc, item) => {acc + (item.soldPrice - item.asked)})
  }

  def instantiateBase(list: List[Int]): List[Item] = {
    list.map(n => Item(n, n, n + 1.0))
  }

  def instantiateBad(list: List[Int]): List[ItemBad] = {
    list.map(n => ItemBad(n, Price(n), Price(n + 1.0)))
  }

  def instantiateGood(list: List[Int]): List[ItemGood] = {
    list.map(n => ItemGood(n, PriceVal(n), PriceVal(n + 1.0)))
  }

}