# android-using-hilt
##Android 환경에서 Hilt를 사용한 예시 샘플 코드입니다. (Retrofit2 / DB 포함 / 멀티 모듈 / MVVM / CleanArchitecture / DataBinding)

### 이 코드는 MVVM패턴과 Clean Architecture를 기반으로 멀티모듈을 사용하여 제작한 프로그램입니다.
### 이 프로그램의 목적은 간단한 Hilt 사용과 Retrofit이 구현되어 있으며 
### 모듈은 Presentation(View, ViewModel), Domain(UseCase, Repository), Data(RepositoryImpl, DataSource)로 이루어져 있습니다.
### 또한 구글에서 적극 사용을 추천하고 있는 DataBinding을 통해 Activity/Fragment와 ViewModel 사이의 데이터를 자유롭게 변환 가능하도록 설계했습니다.
### Android를 처음 개발할 때, 다음과 같은 코드를 따라하여 작성하면 효율적으로 유지보수 및 개발을 할 수 있을 것입니다. 
