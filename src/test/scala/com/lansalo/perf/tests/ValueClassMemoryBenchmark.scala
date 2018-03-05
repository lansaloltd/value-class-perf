package com.lansalo.perf.tests

import java.io.File

import com.lansalo.perf.domain.valueclasses._
import com.lansalo.perf.targets.valueclasses.{instantiateA, instantiateB, instantiateC}
import com.lansalo.perf.tests.ValueClassBenchmark.using
import org.scalameter.Measurer
import org.scalameter.api.{Bench, Gen}
import org.scalameter.persistence.SerializationPersistor

object ValueClassMemoryBenchmark extends Bench.OfflineReport {

  override lazy val persistor = SerializationPersistor(new File("target/memoryusage/results"))

  override def measurer = new Measurer.MemoryFootprint

  val ranges: Gen[Int] = Gen.range("size")(10000, 1000000, 40000)

  val numberOfItems: Gen[List[Int]] = for {
    size <- ranges
  } yield (0 until size).toList


  performance of "numberOfItems" in {
    measure method "instantiateA" in {
      using(numberOfItems) in {
        r => instantiateA(r)
      }
    }
  }

  performance of "numberOfItems" in {
    measure method "instantiateB" in {
      using(numberOfItems) in {
        r => instantiateB(r)
      }
    }
  }

  performance of "numberOfItems" in {
    measure method "instantiateC" in {
      using(numberOfItems) in {
        r => instantiateC(r)
      }
    }
  }

}
