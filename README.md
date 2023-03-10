# Branch International Assignment
Mobile version of the web based app that could be used to respond to customer inquiries while on the go.

# π· Previews

<p align="center">
  <img width="250" src="screenshots/1.png" />
  <img width="250" src="screenshots/2.png" />
  <img width="250" src="screenshots/3.png" />
</p>

# π  Tech Sacks & Open Source Libraries
- Jetpack Compose
- ViewModel
- Hilt
- Compose Navigation
- DataStore
- Retrofit 
- moshi

# File structure
<details>
    <summary>Click me</summary>

  ```
  branch_project
    β   BranchApplication.kt
    β   MainActivity.kt
    β
    ββββdata
    β   ββββlocal
    β   ββββmapper
    β   β       MessageMapper.kt
    β   β
    β   ββββremote
    β   β       BranchApi.kt
    β   β       LoginRequest.kt
    β   β       LoginResponse.kt
    β   β       MessageDto.kt
    β   β       MessageRequest.kt
    β   β
    β   ββββrepository
    β           BranchRepositoryImpl.kt
    β
    ββββdi
    β       AppModule.kt
    β       RepositoryModule.kt
    β
    ββββdomain
    β   ββββmodel
    β   β       Message.kt
    β   β
    β   ββββrepository
    β           BranchRepository.kt
    β
    ββββpresentation
    β   ββββchat
    β   β       ChatScreen.kt
    β   β       ChatState.kt
    β   β       ChatViewModel.kt
    β   β       MessageItem.kt
    β   β
    β   ββββhome
    β   β       HomeScreen.kt
    β   β       HomeState.kt
    β   β       HomeViewModel.kt
    β   β       ThreadItem.kt
    β   β
    β   ββββlogin
    β   β       LoginScreen.kt
    β   β       LoginState.kt
    β   β       LoginViewModel.kt
    β   β
    β   ββββnavigation
    β           HomeNavGraph.kt
    β           RootNavGraph.kt
    β           Screen.kt
    β
    ββββui
    β   ββββtheme
    β           Color.kt
    β           Shape.kt
    β           Theme.kt
    β           Type.kt
    β
    ββββutil
            AgentPreferences.kt
            Resource.kt
  ```
</details>
