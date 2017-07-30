package io.github.iepi.roulette

case class BetType (gainFactor: Int, checker:(Slice => Boolean))