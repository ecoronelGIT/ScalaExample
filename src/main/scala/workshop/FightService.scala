import workshop._

object FightService {

  def doMissions(missions : List[Mission], team: Team) : Team = {
    def doMission(mission: Mission, missions: List[Mission], team: Team): Team = mission.doMission(team) match {
      case Team(List()) => Team(List())
      case resultTeam => missions match {
        case List() => resultTeam
        case  _ => doMission(missions.head, missions.tail, resultTeam)
      }
    }
    doMission(missions.head, missions.tail, team)
  }

  def main(args: Array[String]): Unit = {
    val team: Team = Team(List(Fighter("Yamcha", 1), Fighter("Krillin", 2000), Fighter("Goku", 5000), Fighter("Vegeta", 4000)))
    val mission1: Mission = Mission(List(Activity(2000)))
    val mission2: Mission = Mission(List(Activity(200)))
    val missions: List[Mission] = List(mission1, mission2)

    println("MISION 1")
    val result: Team = mission1.doMission(team)
    result match {
      case Team(List()) => println("team failed")
      case _ => println("team won")
    }

    result.fighters.foreach(fighter => {
      println(fighter.name)
      println(fighter.energy)
    })

    println("MISION 2")
    val result2: Team = doMissions(missions, team)

    result2.fighters.foreach(fighter => {
      println(fighter.name)
      println(fighter.energy)
    })

  }
}
