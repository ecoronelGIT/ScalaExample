package workshop

case class Team(fighters: List[Fighter]) {

  def doActivity(activity: Activity): Team = fighters match {
    case Nil => Team(List())
    case _::Nil => Team(List())
    case leader::tail => activity.perform(leader) match {
      case (Some(fighter),_) => Team(fighter::tail)
      case (_, Some(rest)) => Team(tail).doActivity(rest)
      case (_, _) => Team(tail)
    }
  }
}
