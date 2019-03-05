package workshop

case class Fighter(name: String, energy: Int) {

  def consumeEnergy(toConsume: Int): Option[Fighter] = toConsume match {
    case x: Int if x < energy => Some(Fighter(this.name, energy - x))
    case _ => None
  }

}


