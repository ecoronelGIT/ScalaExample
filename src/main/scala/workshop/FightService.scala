import workshop._

object FightService {

  def main(args: Array[String]): Unit = {
    val team: Team = Team(List(Fighter("Yamcha", 1), Fighter("Krillin", 2000), Fighter("Goku", 5000)))
    val mission: Mission = Mission(List(Activity(2000)))

    val result: Team = mission.doMission(team)

    result match {
      case Team(List()) => println("team failed")
      case _ => println("team won")
    }

    result.fighters.foreach(fighter => {
      println(fighter.name)
      println(fighter.energy)
    })

  }
}

