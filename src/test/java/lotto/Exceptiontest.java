package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Exceptiontest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력받은 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByUntidyMoney() {
        assertThatThrownBy(() -> Store.validate(1800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByNegativeMoney() {
        assertThatThrownBy(() -> Store.validate(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}