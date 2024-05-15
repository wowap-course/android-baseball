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
  - [] life increase 오버라이딩
  - [] life decrease 오버라이딩
  - [x] showLife 리팩토링
  - [x] initStartGame -> presenter.StartGame 리팩토링
- [] MainActivity 리팩토링
