package workshop

case class Mission(activities: List[Activity]) {

  def doMission(team: Team): Team = this.activities match {
    case Nil => team
    case head :: tail => Mission(tail).doMission(team.doActivity(head))
  }

  def totalEnergy = activities.map(_.energy).sum

}
