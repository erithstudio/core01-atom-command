package org.erith.core.atomcommand.eventhandlers;

import org.erith.core.atomcommand.annotations.EventHandlerInfo;
import org.erith.core.atomcommand.annotations.Tooltip;

/// <summary>
/// The block will execute when the specified message is received from a Send Message command.
/// </summary>
@EventHandlerInfo(category = "Scene",
        eventHandlerName = "Message Received",
        helpText = "The block will execute when the specified message is received from a Send Message command.")
public class MessageReceived extends EventHandler {

    @Tooltip(message = "Fungus message to listen for")
    protected String message = "";

    /// <summary>
    /// Called from Flowchart when a message is sent.
    /// </summary>
    /// <param name="message">Message.</param>
    public void OnSendFungusMessage(String message) {
        if (this.message == message) {
            ExecuteBlock();
        }
    }

    @Override
    public String GetSummary() {
        return message;
    }

}