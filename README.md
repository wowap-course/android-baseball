# android-baseball

< Step 1 Commit >

- [x] TextView "숫자 야구 게임" 표시하기
- [x] TextView "목숨을 입력하세요" 표시하기
- [x] App Bar 구현하기
    - [x] TextView "Baseball" 표시하기
- [x] 이미지 파일 사이즈에 맞춰서 넣기
- [x] Count 세는 변수 화면에 나타내기
- [x] -> Count 이름 변경 : Life
- [x] Plus 버튼 만들어 Count 수 올리기
    - [x] 1~10까지 count 제한
- [x] Minus 버튼 만들어 Count 수 내리기
    - [x] 1 밑으로 안내려가게 구현
- [x] "게임 시작!" 버튼 만들기
- [x] 게임시작 버튼을 누르면 다른 창을 띄우게 구현하기
- [x] 다른창 App Bar 구현하기
    - [x] TextView "Baseball" 표시하기
- [x] 뒤로가기 구현하기
- [x] TextView "남은 목숨 : " 나타내기
    - [x] TextView "{lifeCount}" 표시하기

< Test >

- [x] life는 1 밑으로 내려가면 안된다
- [x] life는 10 위로 올라가면 안된다
- [x] life가 5 일때 증가시키면 6이 된다
- [x] life가 3 일때 감소시키면 2이 된다
- [x] life가 10 일때 증가시키면 10이 된다
- [x] life가 1 일때 감소시키면 1이 된다

--- 

< Step2 Commit >
- [x] MVP로 전환하기 위한 MainContract 만들기
  - [x] interface View 구현
  - [x] interface Presenter 구현
- [x] MainPresenter 만들기
  - [x] life increase 오버라이딩
  - [x] life decrease 오버라이딩
  - [x] showLife 리팩토링
  - [x] initStartGame -> presenter.StartGame 리팩토링
- [x] MainActivity 리팩토링
- [x] EditView "세 자리 숫자를 입력해주세요" 구현
- [x] GameContract 만들기
  - [x] interface View 구현
  - [x] interface Presenter 구현
- [x] GamePresenter 만들기 
  - [x] domain input number 받아서 게임시작하기 
- [x] button "도전" 구현
  - [x] Domain Baseball Game 연동
  - [x] EditView Text를 받아서 (= inputnumber)로 Game 시작하기
  - [x] StrikeCount BallCount를 Toast로 띄우기 
  - [x] 성공창, 실패창에서 나가기 버튼 구현 -> finish() 
  - [x] 성공창, 실패창에서 재시작 버튼 구현 
  - [x] Strike = 3일때 성공창 띄우기 
  - [x] Strike != 3일때 실패창 띄우기 
    - [x] life 하나 깎기 

--- 

< Step3 Commit >
- [x] RecyclerView_item.xml 만들기
- [x] RecyclerView adpter 구현
- [x] ViewHolder 구현
- [x] Count data class 구현
- [x] presenter에 adapter 연결
- [x] activity adapter에 연결

---

< Step4 Commit >
- [x] MainActivity MVP -> MVVM
  - [x] MainContract 삭제
  - [x] MainPresenter -> MainViewModel Refactoring
- [x] GameActivity MVP -> MVVM
  - [x] GameContract 삭제
  - [x] GamePresenter -> GameViewModel Refactoring
자세한 내용 : **[[Notion]](https://x1nu.notion.site/Android-BaseBallGame-eaa2d2ab49ec4039910f67fa9e82008d)**