package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationMessage {
    MESSAGE_SENT("Wiadomość wysłana"),
    MESSAGE_DELETED("Wiadomość została przeniesiona do kosza.");

    String text;
}