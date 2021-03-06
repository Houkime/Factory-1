/*******************************************************************************
 * Copyright 2015 Maximilian Stark | Dakror <mail@dakror.de>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


package de.dakror.factory.game.entity.machine.tube;

import java.awt.Color;

import de.dakror.factory.game.entity.Entity;
import de.dakror.factory.game.world.Block;

/**
 * @author Dakror
 */
public class GoldTube extends Tube {
	public GoldTube(float x, float y) {
		super(x, y);
		speed = 10f;
		color = Color.decode("#cd6f00");
		bgColor = Color.decode("#cdb598");
		
		name = "Gold-Rohr";
	}
	
	@Override
	public Entity clone() {
		return new GoldTube(x / Block.SIZE, y / Block.SIZE);
	}
}
