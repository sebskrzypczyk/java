package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Alert {
    MESSAGE_SENT("Wiadomość wysłana");

    String text;
}