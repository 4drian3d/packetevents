/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2021 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.retrooper.packetevents.event;

import io.github.retrooper.packetevents.event.impl.*;

/**
 * Abstract packet listener.
 *
 * @author retrooper
 * @since 1.8
 */
public abstract class PacketListenerAbstract {
    private final Priority priority;

    public PacketListenerAbstract(Priority priority) {
        this.priority = priority;
    }


    public PacketListenerAbstract() {
        this.priority = Priority.NORMAL;
    }

    public Priority getPriority() {
        return priority;
    }

    public void onPostPlayerInject(PostPlayerInjectEvent event) {
    }

    public void onPlayerInject(PlayerInjectEvent event) {
    }

    public void onPlayerEject(PlayerEjectEvent event) {
    }

    public void onPacketEventExternal(PacketEvent event) {
    }

    public void onPacketReceive(PacketReceiveEvent event) {
    }

    public void onPacketSend(PacketSendEvent event) {

    }

    /**
     * The priority of packet listeners affect the order they will be invoked in.
     * The lowest priority listeners are invoked first, the most high ones are invoked last.
     * The most high priority listener has the final decider on an event being cancelled.
     * This priority can be specified in the PacketListenerAbstract constructor.
     * If you don't specify a priority in the constructor, it will use the {@link #NORMAL} priority.
     *
     * @author retrooper
     * @since 1.8
     */
    public enum Priority {
        /**
         * Listener is of very low importance.
         * This listener will be ran first.
         */
        LOWEST,

        /**
         * Listener is of low importance.
         */
        LOW,

        /**
         * Default listener priority.
         * Listener is neither important nor unimportant and may run normally.
         */
        NORMAL,

        /**
         * Listener is of high importance.
         */
        HIGH,

        /**
         * Listener is of critical importance and wants to decide the cancellation of an event.
         */
        HIGHEST,

        /**
         * Listener is purely trying to decide the cancellation of an event.
         * This listener should be ran last.
         */
        MONITOR;

        public static Priority getById(byte id) {
            return values()[id];
        }

        public byte getId() {
            return (byte) ordinal();
        }
    }
}
