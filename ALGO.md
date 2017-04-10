#Fonctionnement global de l'IA

##Requis

Le serveur d'ia a besoin de l'état actuel du jeu à CHAQUE requête.

il reçoit donc un tableau de 19*19 et le score (en nb de tenailles) de chacun.

##Fonctionnement

Pour chaque case, le script donne un poids en fonction de plusieurs possibilités:

 - Si la case peut permettre une tenaille.
 - Si la case permet de préparer une ligne de 5.
 - Si la case empêche l'adversaire de faire une ligne.
 - Si la case empêche l'adversaire de faire une tenaille.
 - Le poids des deux dernières est pondéré par le score actuel (si on est menés, il est plus important de défendre !).
 
##Implémentation

L'implémentation peut se faire de manière bête et méchante (un algo tout simple qui passe sur chaque case) ou
via un réseau neuronal (mais peut être trop peu de temps pour la phase d'apprentissage).