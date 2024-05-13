# android-baseball
# 게임 방법
1. 세자리 수를 입력한다.
2. 심판이 알려주는 결과를 토대로 상대방의 수를 유추한다.
3. 세자리 숫자를 모두 맞히면 게임은 종료된다.
4. 게임을 더하고 싶으면 1, 그만하고 싶으면 2을 입력한다.

# 게임 규칙
- 세자리 수를 맞히는 게임이다.
- 자릿수와 숫자 모두를 맞히면 '스트라이크'이다.
- 숫자만 맞히면 '볼'이다.
- 숫자를 아무것도 맞히지 못하면 '낫싱'이다.
- 맞히지 못한 숫자에 대한 출력은 없다.

## 예시
- 정답이 123인 경우
    - 입력이 345인 경우: '1볼' (4와 5에 대한 출력은 없습니다.)
    - 입력이 136인 경우: '1스트라이크 1볼' (1은 자릿수와 숫자가 일치하고, 3은 숫자만 맞힙니다.)
    - 입력이 789인 경우: '낫싱' (모든 숫자가 정답에 포함되지 않습니다.)
<br />
  
# 구현 
## 메인 화면
- [x] 게임 시작 버튼을 통해 게임화면으로 전환된다.
- [x] +, - 버튼으로 목숨의 개수를 조절할 수 있다.
- [x] 목숨의 개수를 최소보다 작게 줄이거나 최대보다 크게 늘이려고 하면 토스트 메시지가 출력된다.

## Unit
### 목숨의 개수
- [x] 목숨은 기본적으로 1개가 주어진다.
- [x] 목숨은 1보다 작을 수 없고 19보다 클 수 없다.