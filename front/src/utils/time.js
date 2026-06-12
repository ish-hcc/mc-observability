// Format an ISO/epoch timestamp in the browser's local timezone (YYYY-MM-DD HH:mm:ss).
export function formatLocalTime(value) {
  if (value == null || value === '') return '';
  let v = value;
  // A timezone-less datetime string from the backend (e.g. "2026-06-12T08:32:26.165371")
  // is UTC; mark it as such so it isn't misparsed as the browser's local time.
  if (typeof v === 'string') {
    const s = v.trim();
    if (/^\d{4}-\d{2}-\d{2}[T ]\d{2}:\d{2}:\d{2}(\.\d+)?$/.test(s)) {
      v = s.replace(' ', 'T') + 'Z';
    }
  }
  const d = new Date(v);
  if (Number.isNaN(d.getTime())) return String(value);
  const p = (n) => String(n).padStart(2, '0');
  return `${d.getFullYear()}-${p(d.getMonth() + 1)}-${p(d.getDate())} ${p(d.getHours())}:${p(d.getMinutes())}:${p(d.getSeconds())}`;
}
