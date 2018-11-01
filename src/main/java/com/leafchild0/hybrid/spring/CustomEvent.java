package com.leafchild0.hybrid.spring;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.UUID;

import static com.leafchild0.hybrid.spring.CustomEvent.EventType.*;

/**
 * Simple pojo to store display data in grid
 * @author victor
 * @date 10/15/18
 */
public class CustomEvent {

	private long id;
	private String description;
	private LocalDate date;
	private EventType type;

	/**
	 * New instance with all parameters
	 */
	CustomEvent(String description, LocalDate date, EventType type) {

		this.description = description;
		this.date = date;
		this.type = type;
		this.id = UUID.randomUUID().getMostSignificantBits();
	}

	/**
	 * New instance with date
	 */
	CustomEvent(LocalDate date) {

		this.date = date;
		this.description = UUID.randomUUID().toString();
		this.type = getRandomEventType();
		this.id = UUID.randomUUID().getMostSignificantBits();
	}

	private EventType getRandomEventType() {

		EventType random = null;
		try {
			random = values()[SecureRandom.getInstanceStrong().nextInt(values().length)];
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return random;
	}

	public long getId() {

		return id;
	}

	public String getDescription() {

		return description;
	}

	public LocalDate getDate() {

		return date;
	}

	public EventType getType() {

		return type;
	}

	/**
	 * Event type enum
	 */
	enum EventType {
		CREATED("Created"),
		UPDATED("Updated"),
		DELETED("Deleted"),
		LOGIN("Login"),
		LOGOUT("Logout"),
		LOGIN_RETRY("Login Retry"),
		ACCOUNT_LOCKED("Account Locked"),
		PASSWORD_EXPIRED("Password Expired"),
		PASSWORD_CHANGED("Password Changed");

		private String text;

		EventType(String text) {

			this.text = text;
		}

		public String getText() {

			return text;
		}

		public static EventType fromString(String text) {

			if (text != null) {
				for (EventType event : values()) {
					if (text.equalsIgnoreCase(event.text)) {
						return event;
					}
				}
			}
			return null;
		}
	}
}
