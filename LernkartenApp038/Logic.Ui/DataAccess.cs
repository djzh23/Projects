using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization.Formatters.Binary;
using System.Threading.Tasks;
using System.IO;
using System.Xml.Serialization;
using System.Data;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui
{
    public class DataAccess
    {
        private static DataAccess instance;

        public SetViewModel setViewModel { get; set; }

        private DataAccess()
        {
            setViewModel = new SetViewModel();
        }
        public static DataAccess Instance
        {
            get
            {
                if (instance == null)
                    instance = new DataAccess();

                return instance;
            }
        }

        private void SerializeDataSet(string filename)
        {
            XmlSerializer ser = new XmlSerializer(typeof(DataSet));

            // Creates a DataSet; adds a table, column, and ten rows.
            DataSet ds = new DataSet("myDataSet");
            DataTable t = new DataTable("table1");
            DataColumn c = new DataColumn("thing");
            t.Columns.Add(c);
            ds.Tables.Add(t);
            DataRow r;
            for (int i = 0; i < 10; i++)
            {
                r = t.NewRow();
                r[0] = "Thing " + i;
                t.Rows.Add(r);
            }
            TextWriter writer = new StreamWriter(filename);
            ser.Serialize(writer, ds);
            writer.Close();
        }
    }
}
