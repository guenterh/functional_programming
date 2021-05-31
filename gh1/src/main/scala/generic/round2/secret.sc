
import generic.round2.GenericFunctionExercises._

secret.map(bytes => new String(bytes.toArray))
  .map(_.reverse)
  .swap
