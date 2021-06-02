package org.goodfood2.scala

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import java.util.concurrent.{ ThreadLocalRandom, TimeUnit }
class ApiGatlingSimulationTest extends Simulation {

    var scn = scenario("AddAndFindPersons").repeat(1, "n"){
          exec(
            http("AddPerson-API")
              .get("http://globecen.freeboxos.fr:8080/Article")
              .header("Content-Type", "application/json")
              .check(status.is(200))
          ).pause(Duration.apply(5, TimeUnit.MILLISECONDS))
    }.repeat(1, "n") {
          exec(
            http("GetPerson-API")
              .get("http://globecen.freeboxos.fr:8080/Article/${n}")
              .check(status.is(200))
          )
    }
    setUp(scn.inject(atOnceUsers(2000))).maxDuration(FiniteDuration.apply(60, "seconds"))
}