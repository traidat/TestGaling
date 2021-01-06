import com.github.mnogu.gatling.mqtt.Predef._
import io.gatling.core.Predef._
import io.gatling.core.session
import org.fusesource.mqtt.client.QoS

import scala.concurrent.duration._


class MqttSimulation extends Simulation {

  val numberOfDevice = 1

  var devices = MQTTTest.createDevices(numberOfDevice)

  val mqttConfiguration = mqtt
    .host("tcp://10.240.177.70:1883")
    .userName("${device}")
    .password("${device}")

  val connect = exec(mqtt("connect")
    .connect())

  val publish = repeat(1) {
    exec(mqtt("publish")
      .publish("v1/devices/me/telemetry", "[{\n  \"positionTime\": 1600358989,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10007,\n  \"lng\": 10578243,\n  \"lat\": 2104630,\n  \"gpsSpeed\": 64,\n  \"heading\": 15,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358990,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578236,\n  \"lat\": 2104630,\n  \"gpsSpeed\": 64,\n  \"heading\": 17,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358991,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578229,\n  \"lat\": 2104629,\n  \"gpsSpeed\": 64,\n  \"heading\": 17,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358992,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578222,\n  \"lat\": 2104630,\n  \"gpsSpeed\": 64,\n  \"heading\": 19,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358993,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578215,\n  \"lat\": 2104631,\n  \"gpsSpeed\": 64,\n  \"heading\": 20,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358994,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578208,\n  \"lat\": 2104632,\n  \"gpsSpeed\": 64,\n  \"heading\": 22,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358995,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578202,\n  \"lat\": 2104633,\n  \"gpsSpeed\": 64,\n  \"heading\": 26,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}, {\n  \"positionTime\": 1600358996,\n  \"positionSource\": \"GPS\",\n  \"dataValidity\": \"REAL_TIME\",\n  \"longType\": \"EAST\",\n  \"latType\": \"NORTH\",\n  \"numberOfStatellites\": 8,\n  \"height\": 10006,\n  \"lng\": 10578195,\n  \"lat\": 2104634,\n  \"gpsSpeed\": 64,\n  \"heading\": 31,\n  \"pdop\": 17,\n  \"hdop\": 9,\n  \"vdop\": 15,\n  \"hacc\": 4,\n  \"major\": \"REPORT_GPS_v2\"\n}]",
        QoS.AT_LEAST_ONCE, retain = false))
      .pause(100 microseconds)
  }

//    val publish = repeat(1000) {
//      exec(mqtt("publish")
//        .publish("v1/devices/me/telemetry","{\"temp\" :" + 70 + "}",
//          QoS.AT_LEAST_ONCE, retain = false))
//        .pause(1000  microseconds)
//    }
//
//    val publish2 = repeat(0) {
//      exec(mqtt("publish")
//        .publish("v1/devices/me/telemetry","{\"temp\" :" + 20 + "}",
//          QoS.AT_LEAST_ONCE, retain = false))
//        .pause(1000 microseconds)
//    }

  val disconnect = exec(mqtt("disconnect")
    .disconnect())

  val feederDevice = devices.map(x => {Map("device" -> x)})

  val scn = scenario("MQTT test")
    .feed(feederDevice)
//    .exec {session =>
//      printf("test1")
//      session}
    .exec(connect)
//    .exec {session =>
//      printf("test2")
//      session}
    .exec(publish)
//    .exec {session =>
//      printf("test3")
//      session}
    .exec(disconnect)

  setUp(scn.inject(rampUsers(numberOfDevice) over (1 seconds)))
    .protocols(mqttConfiguration)
}
