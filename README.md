# kotlin-lotto

## 2단계 - 로또(자동)

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 목록

- [ ] 로또 발급
    - [x] 구입 금액 만큼 로또를 생성한다.
    - [x] 금액이 0 이거나 음수인 경우 로또는 생성되지 않는다.
- [ ] 로또 생성
    - [x] 로또 숫자는 6개이다.
    - [x] 로또 숫자들은 랜덤하게 생성된다.
    - [x] 로또 숫자들은 오름차순으로 정렬된다.
- [ ] 로또 당첨
    - [x] 당첨된 숫자 개수를 확인한다.
    - [x] 맞춘 번호 개수 만큼 당첨 금액이 계산된다.
    - [x] 구매 금액과 당첨금을 비교해서 수익률을 계산한다.
- [ ] 당첨 번호 입력
    - [x] 입력 문장으로 당첨 번호를 분리한다.

### 프로그래밍 요구 사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 힌트

- 로또 자동 생성은 shuffled()을 활용한다.
- sorted()를 활용해 정렬 가능하다.
- contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
