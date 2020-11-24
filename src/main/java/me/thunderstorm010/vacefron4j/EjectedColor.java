/*
 * Copyright 2020 Yiğit Özdemir
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.thunderstorm010.vacefron4j;

public enum EjectedColor {
    BLACK, BLUE, BROWN, CYAN, DARK_GREEN, LIME, ORANGE, PINK, PURPLE, RED, WHITE, YELLOW;

    @Override
    public String toString() {
        if (this == EjectedColor.DARK_GREEN) return "dark_green";
        return super.toString().toLowerCase();
    }
}
