NavigationComponent + ViewBinding + DataBinding


Navigation Component:
- Permet de creer un graph xml representant le shema de navigation de l'application ou d'une part de l'application 
- On peut naviguer d'un shema a l'autre
- Facilement construit depuis l'interface design du fichier xml


- On y declare:
 -  Chaque fragment 
 -  Les arguments qu'un fragment peut eventuellement attendre a l'ouverture
 -  Les actions de navigation realisables par chaque fragment (optionnelement une action custom en cas de retour de cette action avec popupTo)
 -  De nombreuses class sont generees automatiquement a la compilation pour manipuler ces actions depuis le Java (reprenant le nom du fragment ou de l'action avec des suffix comme direction ou action)
 -  https://developer.android.com/guide/navigation/navigation-getting-started (Faire bien attention a tout mettre dans le gradle app et project voir les  gradles de ce projet)


Binding: Permet de generer une class NomDuLayoutBinding

- ViewBinding: permet d'acceder au vues du layout sans avoir besoin de les recuperer avec findViewById()
- https://developer.android.com/topic/libraries/view-binding

- DataBinding: Permet d'indiquer au layout xml des variables (et leurs type) qui pouront etre directement utilise dans le xml pour indiquer a une vue par exemple d'afficher la variable 
- Pour passer la valeur de la variable au layyout on utilise la variable binding a qui on fait setLaVariabe(laVariable)
- On peut utiliser des conditions simples
- On peut ecrire directement la fonction (en lambda) a realiser au click par exemple (utile pour appeler une fonction de navigation de notre shema de navigation par exemple)
- https://developer.android.com/topic/libraries/data-binding


ViewModel scope:
-Dans UsersFragment on passe au viewModelProvider this cela definit que le view model de la meme instance pour ce fragment meme si l'instance du fragment change (exemple de la rotation)
-Dans UserDetailsFragment et AgeFragment on passe getActivity() (et on demande dans ces 2 fragment un viewModel du meem type soit UserDetailsViewModel) donc le scope du viewmodel est l'activity et ces 2 fragments "vivant sur la emem activity" ils recuperent la mem instance de viewModel et par exemple AgeFragment peut afficher l'age du user garder en variable dasn le viewModel et qui y a etait insere par userDetailsFragment lorsqu'il l'avait observe avec le live data retourne par getAllUsers
