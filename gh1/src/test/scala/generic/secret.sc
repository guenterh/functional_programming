import generic.GenericFunctionExercises._

secret
secret.map(_.reverse)

secret.map(
  (bytes: List[Byte]) => new String(bytes.toArray))
    .map(_.reverse)
    .swap

//Variante
secret.map(
  (bytes: List[Byte]) => new String(bytes.toArray).reverse)
  .swap

decoded
