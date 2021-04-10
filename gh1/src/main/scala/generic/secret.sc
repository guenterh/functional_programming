import generic.GenericFunctionExercises._


secret.map(_.reverse)


secret
  .map(bytes => new String (bytes.toArray))
  .map(_.reverse)
  .swap


decoded
