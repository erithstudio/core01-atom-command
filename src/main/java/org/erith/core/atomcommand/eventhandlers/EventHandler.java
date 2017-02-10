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

package org.erith.core.atomcommand.eventhandlers;

import org.erith.core.atomcommand.components.Block;
import org.erith.core.atomcommand.components.Flowchart;

public class EventHandler {
    /**
     * <summary>
     *     The parent Block which owns this Event Handler.
     * </summary>
     */
    protected Block parentBlock;

    /**
     * <summary>
     *     The Event Handler should call this method,
     *     when the event is detected to start executing the Block.
     * </summary>
     * @return boolean isExecuted
     */
    public boolean ExecuteBlock()
    {
        if (parentBlock == null)
        {
            return false;
        }

        if (parentBlock.getEventHandler() != this)
        {
            return false;
        }

        Flowchart flowchart = parentBlock.GetFlowchart();

        // Auto-follow the executing block if none is currently selected
        if (flowchart.getSelectedBlock() == null)
        {
            flowchart.setSelectedBlock(parentBlock);
        }

        return flowchart.ExecuteBlock(parentBlock);
    }

    /**
     * <summary>
     *     Returns custom summary text for the event handler.
     * </summary>
     */
    public String GetSummary()
    {
        return "";
    }
}
