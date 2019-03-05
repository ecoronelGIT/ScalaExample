package workshop

case class Activity(energy: Int) {

  def perform(fighter: Fighter) : (Option[Fighter], Option[Activity]) =
    (fighter.consumeEnergy(this.energy), consumeEnergy(fighter.energy))

  def consumeEnergy(toConsume: Int): Option[Activity] = toConsume match {
    case x: Int if x < energy => Some(Activity(energy - x))
    case _ => None
  }

}
