package pt.whiteroad.plugins.notifications

class Notification {

  NotificationTopic topic
  String message
  Date creationDate
  Date scheduledDate

  static mapping = {
    message type: 'text'
  }

  static constraints = {
    topic(nullable: false)
    message(blank: false, size: 1 .. 768)
    scheduledDate(nullable: true, validator: {val, obj -> if(val){val >  new Date()}})
    creationDate(nullable: true)
  }

  def beforeInsert = {
    creationDate = new Date()
  }
}