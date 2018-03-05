package com.lansalo.perf.tests

import java.io.File

import com.lansalo.perf.domain.valueclasses._
import com.lansalo.perf.targets.valueclasses._
import org.scalameter.Measurer
import org.scalameter.api.{Bench, Gen}
import org.scalameter.persistence.SerializationPersistor

object ValueClassBenchmark extends Bench.OfflineReport {

  override lazy val persistor = SerializationPersistor(new File("target/timeusage/results"))

  val ranges: Gen[Int] = Gen.range("size")(10000, 1000000, 40000)

  val numberOfItems: Gen[List[Int]] = for {
    size <- ranges
  } yield (0 until size).toList

  val items: Gen[List[Item]] = for {
    size <- ranges
  } yield (0 until size).toList.map(n => Item(n, n, n + 1.0))

  val badItems: Gen[List[ItemBad]] = for {
    size <- ranges
  } yield (0 until size).toList.map(n => ItemBad(n, Price(n), Price(n + 1.0)))

  val goodItems: Gen[List[ItemGood]] = for {
    size <- ranges
  } yield (0 until size).toList.map(n => ItemGood(n, PriceVal(n), PriceVal(n + 1.0)))

  performance of "items" in {
    measure method "totalPerformanceA" in {
      using(items) in {
        r => totalPerformanceA(r)
      }
    }
  }

  performance of "badItems" in {
    measure method "totalPerformanceB" in {
      using(badItems) in {
        r => totalPerformanceB(r)
      }
    }
  }

  performance of "goodItems" in {
    measure method "totalPerformanceC" in {
      using(goodItems) in {
        r => totalPerformanceC(r)
      }
    }
  }

}
