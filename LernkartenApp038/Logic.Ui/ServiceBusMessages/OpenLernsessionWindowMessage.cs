using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ServiceBusMessages
{
    public class OpenLernsessionWindowMessage
    {
        public OpenLernsessionWindowMessage() { }

        public OpenLernsessionWindowMessage(object temp)
        {
            this.Temp = temp;
        }
        public object Temp { get; set; }
    }
}
