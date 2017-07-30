package io.github.iepi.roulette

trait Strategy extends ((Int, Int) => Bet)
