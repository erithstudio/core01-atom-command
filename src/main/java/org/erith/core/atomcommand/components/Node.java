/**
 * Copyright 2017, Denis Prasetio, Erith Studio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 * at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.erith.core.atomcommand.components;

public class Node {
    protected Object nodeRect;
    protected Object tint;
    protected boolean useCustomTint;

    public Object getNodeRect() {
        return nodeRect;
    }

    public void setNodeRect(Object nodeRect) {
        this.nodeRect = nodeRect;
    }

    public Object getTint() {
        return tint;
    }

    public void setTint(Object tint) {
        this.tint = tint;
    }

    public boolean isUseCustomTint() {
        return useCustomTint;
    }

    public void setUseCustomTint(boolean useCustomTint) {
        this.useCustomTint = useCustomTint;
    }
}
