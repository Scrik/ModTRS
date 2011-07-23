package yetanotherx.bukkitplugin.ModTRS.event;

public abstract class Event {

    private boolean cancelled = false;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public abstract Type getType();

    public enum Type {
        
        /**
         * Called when /mod-broadcast is sent
         */
        COMMAND_MOD_BROADCAST,
        /**
         * Called when /check is sent
         */
        COMMAND_CHECK,
        /**
         * Called when /check-id is sent
         */
        COMMAND_CHECK_ID, 
        /**
         * Called when /claim is sent
         */
        COMMAND_CLAIM,
        /**
         * Called when /complete or /done is sent
         */
        COMMAND_COMPLETE,
        /**
         * Called when /help is sent
         */
        COMMAND_HELP,
        /**
         * Called when /hold is sent
         */
        COMMAND_HOLD,
        /**
         * Called when /modlist is sent
         */
        COMMAND_MODLIST,
        /**
         * Called when /modreq is sent
         */
        COMMAND_MODREQ,
        /**
         * Called when /reload is sent
         */
        COMMAND_RELOAD,
        /**
         * Called when /reopen is sent
         */
        COMMAND_REOPEN,
        /**
         * Called when /tp-id is sent
         */
        COMMAND_TELEPORT,
        /**
         * Called when /unclaim is sent
         */
        COMMAND_UNCLAIM
    }
}