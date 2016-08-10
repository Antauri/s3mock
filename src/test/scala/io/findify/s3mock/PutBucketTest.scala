package io.findify.s3mock
import scala.collection.JavaConversions._
/**
  * Created by shutty on 8/10/16.
  */
class PutBucketTest extends S3MockTest {
  "s3 mock" should "create buckets" in {
    s3.listBuckets().isEmpty shouldBe true
    s3.createBucket("hello").getName shouldBe "hello"
    s3.listBuckets().exists(_.getName == "hello") shouldBe true
  }
  it should "create buckets with region" in {
    s3.createBucket("hello2", "us-west-1")
    s3.listBuckets().exists(_.getName == "hello2") shouldBe true
  }
}