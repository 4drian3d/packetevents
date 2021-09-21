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

package io.github.retrooper.packetevents.wrapper.game.client;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.manager.player.ClientVersion;
import io.github.retrooper.packetevents.protocol.PacketType;
import io.github.retrooper.packetevents.wrapper.PacketWrapper;

/**
 * This packet is sent when the player changes their slot selection.
 */
public class WrapperGameClientHeldItemChange extends PacketWrapper<WrapperGameClientHeldItemChange> {
    private int slot;

    public WrapperGameClientHeldItemChange(PacketReceiveEvent event) {
        super(event);
    }

    public WrapperGameClientHeldItemChange(int slot) {
        super(PacketType.Game.Client.HELD_ITEM_CHANGE.getID());
        this.slot = slot;
    }

    @Override
    public void readData() {
        this.slot = readShort();
    }

    @Override
    public void readData(WrapperGameClientHeldItemChange wrapper) {
        this.slot = wrapper.slot;
    }

    @Override
    public void writeData() {
        writeShort(slot);
    }

    /**
     * The slot which the player has selected.
     *
     * @return Target slot
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Modify the slot which the player has selected.
     *
     * @param slot Target slot
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }
}